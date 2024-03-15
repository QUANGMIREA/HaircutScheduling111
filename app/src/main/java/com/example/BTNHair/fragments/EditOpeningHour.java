package com.example.BTNHair.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.BTNHair.R;
import com.example.BTNHair.activities.MainActivity;
import com.example.BTNHair.classes.Day;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditOpeningHour#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditOpeningHour extends Fragment {

    MainActivity mainActivity;
    public FirebaseDatabase database;
    private String chosenDay;
    private boolean dayIsSelected;
    private final String[] days = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public EditOpeningHour() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EditOpeningHour.
     */
    public static EditOpeningHour newInstance() {
        EditOpeningHour fragment = new EditOpeningHour();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        mainActivity = (MainActivity) getActivity();
        mainActivity.VerifyOperationTimeExist();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_opening_hour, container, false);

        Spinner spinner = view.findViewById(R.id.dayChooseSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mainActivity, android.R.layout.simple_spinner_item, days);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
                chosenDay = spinner.getSelectedItem().toString();
                dayIsSelected = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        EditText startTime = view.findViewById(R.id.editTextTimeStart);
        EditText endTime = view.findViewById(R.id.editTextTimeEnd);
        CheckBox dayOffCheckBox = view.findViewById(R.id.checkBoxDayOff);

        Button initOpeningHours = view.findViewById(R.id.buttonInitDaysHour);
        initOpeningHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startHour = startTime.getText().toString();
                String endHour = endTime.getText().toString();
                Boolean dayOff = dayOffCheckBox.isChecked();

                if(dayOff){
                    startHour = "00:00";
                    endHour = "00:00";
                }

                if (!dayIsSelected)
                {
                    Toast.makeText(mainActivity, "Vui lòng chọn ngày!", Toast.LENGTH_LONG).show();
                }
                else if (startHour.isEmpty())
                {
                    Toast.makeText(mainActivity,
                            "Vui lòng chọn giờ bắt đầu!", Toast.LENGTH_LONG).show();
                }
                else if (endHour.isEmpty())
                {
                    Toast.makeText(mainActivity, "\n" +
                            "Vui lòng chọn giờ kết thúc!", Toast.LENGTH_LONG).show();
                }
                else {
                    Day day = new Day(chosenDay,startHour,endHour,dayOff);
                    UpdateOpeningHour(day);
                }
            }
        });
        return view;
    }
    public void UpdateOpeningHour(Day day) {
        DatabaseReference myRef = database.getReference("settings");
        myRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                }
                else {
                    myRef.child("OperationTime").child(convertDayStrToNum(day.getName())).setValue(day);
                    Toast.makeText(mainActivity, "Đã cập nhật thành công thời gian hoạt động vào", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private String convertDayStrToNum(String day)
    {
        switch (day)
        {
            case "Sunday":
                return "1";
            case "Monday":
                return "2";
            case "Tuesday":
                return "3";
            case "Wednesday":
                return "4";
            case "Thursday":
                return "5";
            case "Friday":
                return "6";
            case "Saturday":
                return "7";
            default:
                return "0";
        }
    }


}