package umn.ac.id.uts_30360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPrefManager sharedPrefManager;
        sharedPrefManager = new SharedPrefManager(this);

        if (sharedPrefManager.getSPSudahLogin()){
            String toastMessage = "Already Logged In, Redirecting . . .";
            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            Intent hvLoggedIN = new Intent(LoginActivity.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            hvLoggedIN.putExtra("FROM_ACTIVITY", "login");
            startActivity(hvLoggedIN);
            finish();
        }

        EditText usernameEditText = (EditText) findViewById(R.id.usernameField);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordField);
        loginButton = findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usernameEditText.getText().toString().equals("uasmobile") && passwordEditText.getText().toString().equals("uasmobilegenap")){
                    String toastMessage = "LOGIN SUCCES";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, "Joshua");
                    // Shared Pref ini berfungsi untuk menjadi trigger session login
                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                    Intent logged = new Intent(LoginActivity.this, MainActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    logged.putExtra("FROM_ACTIVITY", "login");
                    startActivity(logged);
                    finish();
                }else {
                    String toastMessage = "Username or Password are incorrect";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}