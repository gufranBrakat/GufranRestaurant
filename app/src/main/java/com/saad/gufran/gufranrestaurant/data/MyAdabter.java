package com.saad.gufran.gufranrestaurant.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saad.gufran.gufranrestaurant.R;
import com.saad.gufran.gufranrestaurant.data.Product;

/**
 * Created by user on 10/30/2016.
 */
public class MyAdabter extends ArrayAdapter<Product> {
    private DatabaseReference reference;
    public MyAdabter(Context context, int resource) {
        super(context, resource);
    }


    /***
     *
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).
                inflate(R.layout.item_prodact, parent, false);

        TextView tvView1 = (TextView) convertView .findViewById(R.id.tvView1);
        TextView tvView2 = (TextView) convertView .findViewById(R.id.tvView2);
        TextView tvView3 = (TextView) convertView .findViewById(R.id.tvView3);

        final Product M = getItem(position);

        tvView1.setText(M.getKind());
        tvView2.setText(M.getPrice()+"");
        tvView3.setText(M.getName());
        reference = FirebaseDatabase.getInstance().getReference();




       return convertView;

    }
}




