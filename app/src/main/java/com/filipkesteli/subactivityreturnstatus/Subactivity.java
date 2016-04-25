package com.filipkesteli.subactivityreturnstatus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Subactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);
    }

    @Override
    public void finish() {
        //setResult(RESULT_OK);
        //zna kamo ide! Ne treba imati cilj kamo ide. To je paket koji zna kamo ide po REQUEST_CODE-u!
        Intent data = new Intent(); //kao implicitan intent -> zna kamo se vraca
        data.putExtra(MainActivity.PARAMETER_NAME, "USPJESNO OBAVLJENO");
        setResult(RESULT_OK, data);
        super.finish();
    }
}
