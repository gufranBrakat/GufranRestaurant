package com.saad.gufran.gufranrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ReservationActivity extends AppCompatActivity {
    private Button btnreserv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        btnreserv=(Button)findViewById(R.id.btnreserv);
    }
}
