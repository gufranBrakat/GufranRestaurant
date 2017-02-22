package com.saad.gufran.gufranrestaurant.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DatabaseReference;
import com.saad.gufran.gufranrestaurant.R;

/**
 * Created by user on 2/12/2017.
 */
public class MyAdabter2 extends ArrayAdapter<Meal> {
    private DatabaseReference reference;

    public MyAdabter2(Context context, int resource) {
        super(context, resource);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).
                inflate(R.layout.item2_orders, parent, false);












        return convertView;


    }


}



