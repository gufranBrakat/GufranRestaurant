package com.saad.gufran.gufranrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saad.gufran.gufranrestaurant.data.Meal;
import com.saad.gufran.gufranrestaurant.data.MealAdabter;

public class Orders extends AppCompatActivity {
    MealAdabter  mealAdabter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        //todo new adabtr
    }


    private void initListView() {
        String Email= FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.','_');
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
        String email= FirebaseAuth.getInstance().getCurrentUser().getEmail();
        email=email.replace(".","_");

        reference.child(email).child("talabat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mealAdabter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Meal myTask = ds.getValue(Meal.class);
                    mealAdabter.add(myTask);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
