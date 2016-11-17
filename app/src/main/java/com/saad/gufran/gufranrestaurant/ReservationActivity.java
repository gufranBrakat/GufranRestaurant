package com.saad.gufran.gufranrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReservationActivity extends AppCompatActivity {
    private  Button btnSend;
    private ListView etList;
    private MyAdabter adabter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        etList = (ListView) findViewById(R.id.etList);
        btnSend=(Button)findViewById(R.id.btnSend);
        adabter=new MyAdabter(this,R.layout.item_prodact);

        ListView.setAdapter(adabter);







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent i3 = new Intent(ReservationActivity.this, LoginActivity.class);
                startActivity(i3);
                break;

            case R.id.setting:
                break;
        }
        return true;
    }
    @Override
    protected void onStart() {
        super.onStart();
        initListView();
    }


    private void initListView() {
        String Email=FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.','_');
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference(Email);
        reference.child("Tasks").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adabter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    MyTask myTask = ds.getValue(MyTask.class);
                    adabter.add(myTask);
                }
            }





