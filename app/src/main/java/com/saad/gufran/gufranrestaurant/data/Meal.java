package com.saad.gufran.gufranrestaurant.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 11/7/2016.
 */
public class Meal implements Serializable{


    public final static String ONTHEWAY="ontheway";
    public final static String ISNTYETREADY="is not yet ready";
    public final static String READRY="Ready";
    private String orderEmail;
    private String status;
    private ArrayList<Product> drinks;
    private ArrayList<Product> sweets;
    private ArrayList<Product> appetizer;
    private ArrayList<Product> wgabat;
    private ArrayList<Product> salads;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Meal() {
        sweets=new ArrayList<Product>();
        drinks=new ArrayList<Product>();
        appetizer=new ArrayList<Product>();
        wgabat=new ArrayList<Product>();
        salads=new ArrayList<Product>();


    }

    public void add(Product p)
    {
        if(p.getKind().equals(Product.DRINK))
        {
            drinks.add(p);
        }
        if (p.getKind().equals(Product.Sweets))
        {
            sweets.add(p);
        }
        if (p.getKind().equals(Product.Appetizer)){
            appetizer.add(p);
        }
        if (p.getKind().equals(Product.Wgabat))
        {
            wgabat.add(p);

        }
        if (p.getKind().equals(Product.Salads))
        {
            salads.add(p);
        }
    }

    public String getStatus(){return status;}
    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }
     public void setStatus(String status){this.status=status;}

    public ArrayList<Product> getDrinks() {
        return drinks;
    }

    public ArrayList<Product> getSweets() {
        return sweets;
    }

    public ArrayList<Product> getAppetizer() {
        return appetizer;
    }

    public ArrayList<Product> getWgabat() {
        return wgabat;
    }

    public ArrayList<Product> getSalads() {
        return salads;
    }

    public void setDrinks(ArrayList<Product> drinks) {
        this.drinks = drinks;
    }

    public void setSweets(ArrayList<Product> sweets) {
        this.sweets = sweets;
    }

    public void setAppetizer(ArrayList<Product> appetizer) {
        this.appetizer = appetizer;
    }

    public void setWgabat(ArrayList<Product> wgabat) {
        this.wgabat = wgabat;
    }

    public void setSalads(ArrayList<Product> salads) {
        this.salads = salads;
    }
}
