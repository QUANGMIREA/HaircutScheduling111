package com.example.BTNHair;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import android.util.Log;

public class FirestoreManager {
    private static final String TAG = "FirestoreManager";
    private FirebaseFirestore db;

    public FirestoreManager() {
        db = FirebaseFirestore.getInstance();
    }

    public void completeHaircut(String customerId) {
        DocumentReference customerRef = db.collection("customers").document(customerId);
        Map<String, Object> updates = new HashMap<>();
        updates.put("last_haircut_date", new Date());
        customerRef.update(updates)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "Haircut date updated successfully"))
                .addOnFailureListener(e -> Log.w(TAG, "Error updating haircut date", e));
    }
}