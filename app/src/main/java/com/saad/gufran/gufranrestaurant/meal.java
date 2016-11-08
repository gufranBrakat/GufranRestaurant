package com.saad.gufran.gufranrestaurant;

import java.util.ArrayList;

/**
 * Created by user on 11/7/2016.
 */
public class Meal {



    private ArrayList<prodact> drinks;
    private ArrayList<prodact> sweets;
    private ArrayList<prodact> appetizer;
    private ArrayList<prodact> wgabat;
    private ArrayList<prodact> salads;

    public Meal() {
        sweets=new ArrayList<prodact>();
        drinks=new ArrayList<prodact>();
        appetizer=new ArrayList<prodact>();
        wgabat=new ArrayList<prodact>();
        salads=new ArrayList<prodact>();


    }

    public void add(prodact p)
    {
        if(p.getKind().equals(prodact.DRINK))
        {
            drinks.add(p);
        }
        if (p.getKind().equals(prodact.Sweets))
        {
            sweets.add(p);
        }
        if (p.getKind().equals(prodact.Appetizer)){
            appetizer.add(p);
        }
        if (p.getKind().equals(prodact.Wgabat))
        {
            wgabat.add(p);

        }
        if (p.getKind().equals(prodact.Salads))
        {
            salads.add(p);
        }
    }

}
