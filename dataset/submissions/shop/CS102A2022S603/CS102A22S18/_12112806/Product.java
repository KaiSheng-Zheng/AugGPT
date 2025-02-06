// package Exer2;

import java.util.ArrayList;

public class Product {
    //attribute
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private float rateSum;

    //constructor
    public Product(String name, float price) {
        this.id = ++cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }

    //method
    public boolean setRating(int rating){
        if (rating >= 1 && rating <=5){
            this.ratings.add(rating);
            rateSum += rating;
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating(){
        int sum = 0;
        return rateSum == 0? 0:rateSum / ratings.size();
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format(String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating()));
    }

    public boolean equals(Product product) {
        return this.id == product.id;
    }
}
