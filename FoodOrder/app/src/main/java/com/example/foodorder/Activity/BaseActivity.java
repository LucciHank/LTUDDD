package com.example.foodorder.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorder.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
FirebaseAuth mAuth;
FirebaseDatabase database;
<<<<<<< Updated upstream
    public String TAG="Manh";
=======
    public String TAG;
>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database=FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();

        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }
}