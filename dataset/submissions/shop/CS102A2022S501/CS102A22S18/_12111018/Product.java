

import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private Store store;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }
    public boolean setRating(int rating){
        boolean a=rating<=5&&rating>=1;
        if (a){
            ratings.add(rating);
        }
        return a;
    }
    public float getAvgRating(){
        float sum=0;
        if (ratings.size()==0){
            return 0;
        }
        else {
            for (int i=0;i<ratings.size();i++){
                sum=sum+ratings.get(i);
            }
        float result=sum / ratings.size();
        return result;
        }
    }
    public String toString(){
        String result=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating() );
        return result;
    }

    public float getPrice() {
        return price;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }
    public void addRatings(int rating){
        ratings.add(rating);
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }
}
