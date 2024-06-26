package com.example.BTNHair.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.BTNHair.R;
import com.example.BTNHair.activities.MainActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditAdminContactDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditAdminContactDetailsFragment extends Fragment {

    MainActivity mainActivity;

    public EditAdminContactDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EditAdminContactDetailsFragment.
     */
    public static EditAdminContactDetailsFragment newInstance() {
        EditAdminContactDetailsFragment fragment = new EditAdminContactDetailsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_admin_contact_details, container, false);

        Button updatePhone = view.findViewById(R.id.buttonUpdateAdminPhone);
        updatePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText newPhone = view.findViewById(R.id.editTextAdminPhone);
                String phone = newPhone.getText().toString();
                mainActivity = (MainActivity) getActivity();

                if (phone.isEmpty())
                {
                    Toast.makeText(mainActivity, "Please enter new phone number.",Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences.Editor editor = mainActivity.getSharedPreferences(mainActivity.SHARED_PREFS_CONTACT, MODE_PRIVATE).edit();
                    editor.putString(mainActivity.PHONE, phone);
                    editor.apply();

                    Toast.makeText(mainActivity, "\n" +
                            "Phone updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button updateEmail = view.findViewById(R.id.buttonUpdateAdminEmail);
        updateEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText newEmail = view.findViewById(R.id.editTextAdminEmailAddress);
                String email = newEmail.getText().toString();

                mainActivity = (MainActivity) getActivity();

                if (email.isEmpty())
                {
                    Toast.makeText(mainActivity, "Please enter a new email address.",Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences.Editor editor = mainActivity.getSharedPreferences(mainActivity.SHARED_PREFS_CONTACT, MODE_PRIVATE).edit();
                    editor.putString(mainActivity.EMAIL, email);
                    editor.apply();

                    Toast.makeText(mainActivity, "Email updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button updateAddress = view.findViewById(R.id.buttonUpdateAdminAddress);
        updateAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText newAddress = view.findViewById(R.id.editTextAdminAddress);
                String address = newAddress.getText().toString();

                mainActivity = (MainActivity) getActivity();

                if (address.isEmpty())
                {
                    Toast.makeText(mainActivity, "\n" +
                            "Please enter a new address.",Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences.Editor editor = mainActivity.getSharedPreferences(mainActivity.SHARED_PREFS_CONTACT, MODE_PRIVATE).edit();
                    editor.putString(mainActivity.ADDRESS, address);
                    editor.apply();

                    Toast.makeText(mainActivity, "Address updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}