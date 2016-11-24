package com.saad.gufran.gufranrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by user on 10/30/2016.
 */
public class MyAdabter extends ArrayAdapter<Product> {
    public MyAdabter(Context context, int resource) {
        super(context, resource);
    }

    private DatabaseReference reference;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).
                inflate(R.layout.item_prodact, parent, false);

        TextView etViwe1 = (TextView) convertView.findViewById(R.id.etView1);
        TextView etViwe2 = (TextView) convertView.findViewById(R.id.etView2);


        final Product M = getItem(position);


        etViwe1.setText(M.getKind());
        etViwe2.setText(M.getName());

       return convertView;

    }
}




