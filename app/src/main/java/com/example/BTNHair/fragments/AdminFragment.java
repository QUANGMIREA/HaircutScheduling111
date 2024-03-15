package com.example.BTNHair.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.BTNHair.R;
import com.example.BTNHair.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdminFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdminFragment extends Fragment {

    MainActivity mainActivity;

    public AdminFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AdminFragment.
     */
    public static AdminFragment newInstance() {
        AdminFragment fragment = new AdminFragment();
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
        View view = inflater.inflate(R.layout.fragment_admin, container, false);

        Button editDaysoff = view.findViewById(R.id.buttonEditNotAvailableDays);
        editDaysoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(new EditDaysOffFragment());
            }
        });

        Button editUpdatesBoard = view.findViewById(R.id.buttonAddToUpdatesBoard);
        editUpdatesBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(new EditUpdatesBoardFragment());
            }
        });

        Button editOpeningHour = view.findViewById(R.id.buttonOpeningHour);
        editOpeningHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(new EditOpeningHour());
            }
        });

        Button editContactDetails = view.findViewById(R.id.buttonUpdateContactDetails);
        editContactDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(new EditAdminContactDetailsFragment());
            }
        });

        Button todaysAppointments = view.findViewById(R.id.buttonTodayAppointment);
        todaysAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(new TodayAppointmentsFragment());
            }
        });

        return view;
    }
}