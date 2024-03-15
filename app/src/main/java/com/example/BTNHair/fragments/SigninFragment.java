package com.example.BTNHair.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.BTNHair.R;
import com.example.BTNHair.activities.MainActivity;
import com.example.BTNHair.classes.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SigninFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SigninFragment extends Fragment {

    private FirebaseAuth mAuth;
    public FirebaseDatabase database;
    MainActivity mainActivity;

    public SigninFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SigninFragment.
     */
    public static SigninFragment newInstance() {
        SigninFragment fragment = new SigninFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signin, container, false);

        Button register = view.findViewById(R.id.buttonRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nameTextView = view.findViewById(R.id.editTextPersonName);
                EditText emailTextView = view.findViewById(R.id.editTextTextEmailAddressSignin);
                EditText passwordTextView = view.findViewById(R.id.editTextTextPasswordSignin);
                EditText phoneTextView = view.findViewById(R.id.editTextPhone);

                String name = nameTextView.getText().toString();
                String email = emailTextView.getText().toString();
                String password = passwordTextView.getText().toString();
                String phone = phoneTextView.getText().toString();

                mainActivity = (MainActivity) getActivity();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty())
                {
                    Toast.makeText(mainActivity, "\n" +
                            "Vui lòng điền vào tất cả các thông tin cần thiết", Toast.LENGTH_LONG).show();
                }
                else {
                    User user = new User(name, email, password, phone);
                    Register(user);
                }
            }
        });

        return view;
    }

    public void Register(User user) {
        String userName = user.getEmail();
        String password = user.getPassword();
        mAuth.createUserWithEmailAndPassword(userName, password)
                .addOnCompleteListener(mainActivity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            DatabaseReference myRef = database.getReference("users").child(user.getPhone());
                            myRef.setValue(user);
                            mainActivity.Login(userName, password);
                        } else {
                            // If sign in fails, display a message to the user.
                            mainActivity.setFragment(new SigninFragment());
                            Toast.makeText(mainActivity, "Đã xảy ra sự cố, Vui lòng thử lại.\nNote: \n" +
                                    "Cần có email và mật khẩu hợp lệ với ít nhất 6 ký tự.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}