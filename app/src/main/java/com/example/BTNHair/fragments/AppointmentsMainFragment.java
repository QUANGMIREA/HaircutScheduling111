package com.example.BTNHair.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.BTNHair.R;
import com.example.BTNHair.activities.MainActivity;
import com.example.BTNHair.classes.CustomAdapters.HairStylesMenuCustomAdapter;
import com.example.BTNHair.classes.DataModels.HairStyleDataModel;
import com.example.BTNHair.classes.Data.HairStylesMenuData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppointmentsMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppointmentsMainFragment extends Fragment {

    MainActivity mainActivity;

    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<HairStyleDataModel> hairstyleData;
    private static HairStylesMenuCustomAdapter adapter;

    public AppointmentsMainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AppointmentsMainFragment.
     */
    public static AppointmentsMainFragment newInstance() {
        AppointmentsMainFragment fragment = new AppointmentsMainFragment();
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
        View view = inflater.inflate(R.layout.fragment_appointments_main, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.hairstyleRecyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        hairstyleData = new ArrayList<HairStyleDataModel>();
        for (int i = 0; i < HairStylesMenuData.hairStyleArray.length; i++) {
            hairstyleData.add(new HairStyleDataModel(
                    HairStylesMenuData.hairStyleArray[i],
                    HairStylesMenuData.priceArray[i],
                    HairStylesMenuData.drawableArray[i]
            ));
        }
        
        mainActivity = (MainActivity) getActivity();
        adapter = new HairStylesMenuCustomAdapter(hairstyleData,mainActivity);
        recyclerView.setAdapter(adapter);

        return view;
    }
}