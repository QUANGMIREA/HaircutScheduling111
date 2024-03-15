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
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    MainActivity mainActivity;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainFragment.
     */
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button getAppointment = view.findViewById(R.id.buttonScheduleAppointment);
        getAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(new AppointmentsMainFragment());
            }
        });

        Button bookedAppointments = view.findViewById(R.id.buttonShowBookedAppointment);
        bookedAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(new BookedAppoitmentsFragment());
            }
        });

        Button switchUser = view.findViewById(R.id.buttonSwitchUser);
        switchUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.logOut();
                mainActivity.setLoginFragment();
            }
        });

        Button getUserHistory = view.findViewById(R.id.buttonGetApoointmentHistory);
        getUserHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(new UserHistoryFragment());
            }
        });

        Button seeUpdatesBoard = view.findViewById(R.id.buttonUpdateBoard);
        seeUpdatesBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(new UpdatesBoardFragment());
            }
        });

        Button contactUs = view.findViewById(R.id.buttonContactUs);
        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(new ContactUsFragment());
            }
        });

        return view;
    }
}