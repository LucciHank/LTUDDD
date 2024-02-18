package com.example.project162.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project162.Domain.UserProfile;
import com.example.project162.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfileActivity extends BaseActivity {
    private TextView textViewUserName;
    private TextView textViewEmail;
    private TextView textViewPhoneNumber;
    private TextView textViewAddress;
    private Button buttonSave;
    private Button buttonBack;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private UserProfile userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("UserProfile");

        textViewUserName = findViewById(R.id.usernameTextView);
        textViewEmail = findViewById(R.id.emailEditText);
        textViewPhoneNumber = findViewById(R.id.phoneNumberEditText);
        textViewAddress = findViewById(R.id.addressEditText);
        buttonSave = findViewById(R.id.saveButton);
        buttonBack = findViewById(R.id.comebackButton);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserProfile();
            }
        });

        loadUserProfile();
    }

    private void loadUserProfile() {
        String userId = firebaseAuth.getCurrentUser().getUid();
        databaseReference.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userProfile = dataSnapshot.getValue(UserProfile.class);
                if (userProfile != null) {
                    textViewUserName.setText(userProfile.getUserName());
                    textViewEmail.setText(userProfile.getEmail());
                    textViewPhoneNumber.setText(userProfile.getPhoneNumber());
                    textViewAddress.setText(userProfile.getAddress());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void saveUserProfile() {
        String userId = firebaseAuth.getCurrentUser().getUid();
        userProfile.setUserName(textViewUserName.getText().toString());
        userProfile.setEmail(textViewEmail.getText().toString());
        userProfile.setPhoneNumber(textViewPhoneNumber.getText().toString());
        userProfile.setAddress(textViewAddress.getText().toString());
        databaseReference.child(userId).setValue(userProfile).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(UserProfileActivity.this, "User Profile Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UserProfileActivity.this, "Failed to Save User Profile", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



}