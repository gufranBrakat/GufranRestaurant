package com.saad.gufran.gufranrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 10/30/2016.
 */
public class MyAdabter extends ArrayAdapter<Meal> {
    public MyAdabter(Context context, int resource) {
        super(context, resource);
    }
    private DatabaseReference reference;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).
                inflate(R.layout.item_prodact,parent,false);

     TextView etViwe1 = (TextView) convertView .findViewById(R.id.etView1);
        TextView etViwe2=(TextView)convertView.findViewById(R.id.etView2);



        final MyTask myTask=getItem(position);


        etViwe1.setText(myTask.get());
        etViwe2.setText(myTask.get());

        reference = FirebaseDatabase.getInstance().getReference();





