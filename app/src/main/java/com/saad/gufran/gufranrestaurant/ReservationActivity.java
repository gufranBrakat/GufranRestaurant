package com.saad.gufran.gufranrestaurant;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saad.gufran.gufranrestaurant.data.Meal;
import com.saad.gufran.gufranrestaurant.data.MyAdabter;
import com.saad.gufran.gufranrestaurant.data.Product;

public class ReservationActivity extends AppCompatActivity {
    private  Button btnSend;
    private ListView etList;
    private MyAdabter adabter;
    private Meal m;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        etList = (ListView) findViewById(R.id.etList);
        btnSend=(Button)findViewById(R.id.btnSend);
        adabter=new MyAdabter(this,R.layout.item_prodact);
        reference = FirebaseDatabase.getInstance().getReference();
        etList.setAdapter(adabter);






        btnSend.setOnClickListener(sendListener);



            }
    View.OnClickListener sendListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           // m.setAppetizer(stTaskText);




            String email= FirebaseAuth.getInstance().getCurrentUser().getEmail();
            email=email.replace(".","_");
            m.setOrderEmail(email);
            reference.child("restursntUser").child("talabat").push().setValue(m, new DatabaseReference.CompletionListener() {

                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError == null) {
                        Toast.makeText(getBaseContext(), "save ok", Toast.LENGTH_LONG).show();
                        Intent i2= new Intent(ReservationActivity.this,Status.class);
                        startActivity(i2);

                    }


                    else {
                        Toast.makeText(getBaseContext(), "save Err" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                        databaseError.toException().printStackTrace();

                    }


                }
            });

        }
    };


    @Override
    protected void onRestart() {
        super.onRestart();

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
        Intent i=getIntent();
        if (i!=null){
            m=(Meal)i.getExtras().get("meal");
            initListView();
        }

    }


    private void initListView() {
        adabter.clear();

        for (Product p:m.getDrinks())
        {

           adabter.add(p);
        }
        for (Product p:m.getAppetizer()){
            adabter.add(p);
        }
        for (Product p:m.getSalads()){
            adabter.add(p);
        }
        for (Product p:m.getSweets()){
            adabter.add(p);
        }
        for (Product p:m.getWgabat()){
            adabter.add(p);
        }



    }

   }