package com.saad.gufran.gufranrestaurant;

/**
 * Created by user on 11/7/2016.
 */
public class prodact {
    public static final  String DRINK="drink";
    private String name;
    private String kind;
    private double price;

    public prodact(String name, String kind, double price) {
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

    public prodact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "prodact{" +
                "name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
