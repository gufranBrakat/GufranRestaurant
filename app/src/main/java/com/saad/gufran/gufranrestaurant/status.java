package com.saad.gufran.gufranrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saad.gufran.gufranrestaurant.data.Meal;
import com.saad.gufran.gufranrestaurant.data.MealAdabter;
import com.saad.gufran.gufranrestaurant.data.MealStatus;
import com.saad.gufran.gufranrestaurant.data.Product;

import java.security.Provider;

public class Status extends AppCompatActivity {
    private ListView etList1;
    MealStatus statusAdabter;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        etList1 = (ListView) findViewById(R.id.etlist1);
        tv1=(TextView) findViewById(R.id.tv1);
        statusAdabter = new MealStatus(this, R.layout.item2_status);
        etList1.setAdapter(statusAdabter);


    }
       @Override

        protected void onStart(){
            super.onStart();
            initListView();
        }




    private void initListView() {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
        /// String email= FirebaseAuth.getInstance().getCurrentUser().getEmail().replace(".","_");


        reference.child("restursntUser").child("talabat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               statusAdabter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Meal meal = ds.getValue(Meal.class);
                    meal.setKey(ds.getKey());
                    statusAdabter.add(meal);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        }
}
