package com.example.androidproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity
{
    EditText editUsername;
    EditText editEmail;
    EditText editPassword;
    EditText editConfirmPassword;

    Button btnRegister;
    Button btnBack;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // CONNECT TO FIREBASE AUTHENTICATION
        firebaseAuth = FirebaseAuth.getInstance();

        // CONNECT EDITTEXT FIELDS
        editUsername = findViewById(R.id.editUsername);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);

        // CONNECT BUTTONS
        btnRegister = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnBack);


        // REGISTER BUTTON
        btnRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // GET USER INPUT
                String username = editUsername.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString();
                String confirmPassword = editConfirmPassword.getText().toString();

                // CHECK EMPTY FIELDS
                if (username.isEmpty() || email.isEmpty() ||
                        password.isEmpty() || confirmPassword.isEmpty())
                {
                    Snackbar.make(v, "Please fill in all fields", Snackbar.LENGTH_SHORT).show();
                }
                // CHECK PASSWORDS
                else if (!password.equals(confirmPassword))
                {
                    Snackbar.make(v, "Passwords do not match", Snackbar.LENGTH_SHORT).show();
                }

                else
                {
                    // CREATE ACCOUNT IN FIREBASE
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(task ->
                            {
                                if (task.isSuccessful())
                                {
                                    Snackbar.make(v, "Account created successfully!", Snackbar.LENGTH_LONG).show();

                                    // RETURN TO LOGIN SCREEN
                                    firebaseAuth.signOut();
                                    finish();
                                }
                                else
                                {
                                    Snackbar.make(v, "Registration failed: " +
                                            task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                                }
                            });
                }

            }
        });


        // BACK TO LOGIN BUTTON
        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

    }
}
