package com.saad.gufran.gufranrestaurant;

/**
 * Created by user on 11/7/2016.
 */
public class Product {
    public static final  String DRINK="drink";
    public static final  String Wgabat="wgabat";
    public static final  String Salads="salads";
    public static final String Appetizer="Appetizer";
    public static final String Sweets="sweets";
    private String name;
    private String kind;
    private double price;

    public Product(String name, String kind, double price) {
        this.name = name;
        this.kind = kind;
        this.price = price;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
