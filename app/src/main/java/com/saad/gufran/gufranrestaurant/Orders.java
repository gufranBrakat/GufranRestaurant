package com.saad.gufran.gufranrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

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
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        mealAdabter=new MealAdabter(this,R.layout.item2_orders);
        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(mealAdabter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        initListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent i4 = new Intent(Orders.this, LoginActivity.class);
                startActivity(i4);
                break;

            case R.id.setting:
                break;
        }
        return true;
    }




    private void initListView() {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
       /// String email= FirebaseAuth.getInstance().getCurrentUser().getEmail().replace(".","_");


        reference.child("restursntUser").child("talabat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mealAdabter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Meal meal = ds.getValue(Meal.class);
                    meal.setKey(ds.getKey());
                    mealAdabter.add(meal);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
