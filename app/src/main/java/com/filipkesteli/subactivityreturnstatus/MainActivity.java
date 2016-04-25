package com.filipkesteli.subactivityreturnstatus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PARAMETER_NAME = "TEST KLJUC";
    private static final int REQUEST_CODE = 0;

    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        btnSend = (Button) findViewById(R.id.btnSend);
    }

    private void setupListeners() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent();
            }
        });
    }

    private void sendIntent() {
        Intent intent = new Intent(this, Subactivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();

                if (data != null && data.hasExtra(PARAMETER_NAME)) {
                    String message = data.getStringExtra(PARAMETER_NAME);
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
