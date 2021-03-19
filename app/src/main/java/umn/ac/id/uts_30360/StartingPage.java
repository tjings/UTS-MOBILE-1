package umn.ac.id.uts_30360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingPage extends AppCompatActivity {
    Button toLogin;
    Button toProfileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);
        toLogin = (Button) findViewById(R.id.toLoginBtn);
        toProfileBtn = (Button) findViewById(R.id.toProfileBtn);

        toLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent toLogin = new Intent(StartingPage.this, LoginActivity.class);
                startActivity(toLogin);
            }
        });

        toProfileBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent toProfile = new Intent(StartingPage.this, ProfileActivity.class);
                toProfile.putExtra("FROM_ACTIVITY", "starting");
                startActivity(toProfile);
            }
        });
    }
}