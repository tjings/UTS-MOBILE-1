package umn.ac.id.uts_30360;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logged = getIntent();
                String previousActivity = logged.getStringExtra("FROM_ACTIVITY");
                if (previousActivity.equals("songlist")) {
                    Intent back = new Intent(ProfileActivity.this, MainActivity.class);
                    back.putExtra("FROM_ACTIVITY", "profile");
                    startActivity(back);
                }else if (previousActivity.equals("starting")) {
                    Intent intent = new Intent(ProfileActivity.this, StartingPage.class);
                    startActivity(intent);
                }
            }
        });
    }
}