package com.saad.gufran.gufranrestaurant.data;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saad.gufran.gufranrestaurant.R;
import com.saad.gufran.gufranrestaurant.Status;

/**
 * Created by user on 2/12/2017.
 */
public class MealAdabter extends ArrayAdapter<Meal> {
    private DatabaseReference reference;

    public MealAdabter(Context context, int resource) {
        super(context, resource);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).
                inflate(R.layout.item2_orders, parent, false);

        final Meal M = getItem(position);

        TextView tvwagbat = (TextView) convertView.findViewById(R.id.tvwagbat);
        TextView tvsalads = (TextView) convertView.findViewById(R.id.tvsalads);
        TextView tvappetizer = (TextView) convertView.findViewById(R.id.tvappetizer);
        TextView tvordermail = (TextView) convertView.findViewById(R.id.tvordermail);
        TextView tvsweets = (TextView) convertView.findViewById(R.id.tvsweets);
       RadioButton ontheway=(RadioButton) convertView.findViewById(R.id.ontheway);
        RadioButton isnotyetalready =(RadioButton) convertView.findViewById(R.id.isnotyetalready);
       RadioButton ready=(RadioButton) convertView.findViewById(R.id.ready);
        TextView tvdrink = (TextView) convertView.findViewById(R.id.tvdrink);
        ImageButton btndel = (ImageButton) convertView.findViewById(R.id.btndel);
        RadioGroup radioGroup=(RadioGroup) convertView.findViewById(R.id.radiogroup) ;
        RadioGroup radiogroup =null;

       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id=radioGroup.getCheckedRadioButtonId();
             if(id==R.id.ready)
                 M.setStatus(Meal.READRY);

                 if (id == R.id.isnotyetalready)
                     M.setStatus(Meal.ISNTYETREADY);


                 if (id == R.id.ontheway)
                     M.setStatus(Meal.ONTHEWAY);



               reference = FirebaseDatabase.getInstance().getReference();

               reference.child("restursntUser").child("talabat").child(M.getKey()).setValue(M, new DatabaseReference.CompletionListener() {

                   @Override
                   public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                       if (databaseError == null) {
                           Toast.makeText(getContext(), "meal updated ", Toast.LENGTH_LONG).show();
//

                       }


                       else {
                           Toast.makeText(getContext(), "save Err" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                           databaseError.toException().printStackTrace();

                       }


                   }
               });
            }
        });




        tvordermail.setText(M.getOrderEmail());


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



        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference = FirebaseDatabase.getInstance().getReference().child("restursntUser").child("talabat");

                reference.child(M.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                        if (databaseError == null) {
                            Toast.makeText(getContext(), "Deleted!", Toast.LENGTH_LONG).show();
                            remove(M);
                            setNotifyOnChange(true);// t0
                        }
                    }
                });

            }


        });

        return convertView;

    }

}