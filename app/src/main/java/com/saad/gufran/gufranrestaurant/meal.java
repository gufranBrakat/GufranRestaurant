package com.saad.gufran.gufranrestaurant;

import java.util.ArrayList;

/**
 * Created by user on 11/7/2016.
 */
public class meal {



    private ArrayList<prodact> drinks;
    private ArrayList<prodact> sweets;
    private ArrayList<prodact> appetizer;
    private ArrayList<prodact> wgabat;
    private ArrayList<prodact> salads;

    public meal() {
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
        if (p.getKind().equals("sweets"))
        {
            sweets.add(p);
        }
        if (p.getKind().equals("appetizer")){
            appetizer.add(p);
        }
        if (p.getKind().equals("wgabat"))
        {
            wgabat.add(p);

        }
        if (p.getKind().equals("salads"))
        {
            salads.add(p);
        }
    }

}
