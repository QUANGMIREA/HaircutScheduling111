package com.example.BTNHair.classes.Data;

import com.example.BTNHair.classes.DataModels.HairStyleDataModel;

import java.util.HashMap;

public class AppointmentsData {

    public AppointmentsData() {
        this.appointmentsList = new HashMap();
    }

    public HashMap<String, HairStyleDataModel> appointmentsList;

    public AppointmentsData(HashMap value) {
        this.appointmentsList = value;
    }
}
