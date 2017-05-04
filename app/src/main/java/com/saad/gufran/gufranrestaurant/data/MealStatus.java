package com.saad.gufran.gufranrestaurant.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.saad.gufran.gufranrestaurant.R;

/**
 * Created by user on 3/29/2017.
 */
public class MealStatus extends ArrayAdapter<Meal>{

    private DatabaseReference reference;
    public MealStatus(Context context,int resource ){
        super(context,resource);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).
                inflate(R.layout.item2_status, parent, false);

        final Meal M = getItem(position);
        TextView tvwagbat = (TextView) convertView.findViewById(R.id.tvwagbat);
        TextView tvsalads = (TextView) convertView.findViewById(R.id.tvsalads);
        TextView tvappetizer = (TextView) convertView.findViewById(R.id.tvappetizer);
        TextView tvordermail = (TextView) convertView.findViewById(R.id.tvordermail);
        TextView tvsweets = (TextView) convertView.findViewById(R.id.tvsweets);
        TextView tvdrink = (TextView) convertView.findViewById(R.id.tvdrink);
        TextView   tv1=(TextView) convertView.findViewById(R.id.tv1);

        tvordermail.setText(M.getOrderEmail());
        tv1.setText(M.getStatus());


        for (Product p : M.getDrinks()) {
            tvdrink.append(p.getName() + ", ");
        }
        for (Product p : M.getAppetizer()) {
            tvappetizer.append(p.getName() + ",");
        }
        for (Product p : M.getSalads()) {
            tvsalads.append(p.getName() + ",");
        }
        for (Product p : M.getSweets()) {
            tvsweets.append(p.getName() + ",");

        }
        for (Product p : M.getWgabat()) {
            tvwagbat.append(p.getName() + ",");
        }

        return convertView;
    }
}