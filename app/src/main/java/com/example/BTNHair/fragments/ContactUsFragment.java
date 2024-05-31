package com.example.BTNHair.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.BTNHair.R;
import com.example.BTNHair.activities.MainActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactUsFragment extends Fragment {

    MainActivity mainActivity;



    public ContactUsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EditAdminContactDetailsFragment.
     */
    public static ContactUsFragment newInstance() {
        ContactUsFragment fragment = new ContactUsFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        mainActivity = (MainActivity) getActivity();
        SharedPreferences contact_prefs = mainActivity.getSharedPreferences(mainActivity.SHARED_PREFS_CONTACT, MODE_PRIVATE);
        String phone = contact_prefs.getString(mainActivity.PHONE, "0123456789");
        String email = contact_prefs.getString(mainActivity.EMAIL, "lehongquang@gmail.com");
        String address = contact_prefs.getString(mainActivity.ADDRESS, "HCM");

        TextView contactPhone = view.findViewById(R.id.editTextContactPhone);
        contactPhone.setText(phone);

        TextView contactEmail = view.findViewById(R.id.editTextContactEmailAddress);
        contactEmail.setText(email);

        TextView contactAddress = view.findViewById(R.id.editTextContactAddress);
        contactAddress.setText(address);

        return view;
    }
}