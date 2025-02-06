import java.util.ArrayList;

import static java.lang.String.format;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    //Constructor
    public Product(String name,float price){
    cnt++;
    this.id=cnt;
    this.name=name;
    this.price=price;
    }
    //Methods
    //???1+2
    public boolean setRating(int rating){
        if(rating>=1&rating<=5){this.ratings.add(rating);return true;}
        else {return false;}
    }
    public int getRating(){
        int total=0;
        for (int i:this.ratings) {
            total+=i;
        }
        return total;
    }
    //???3+4
    public float getAvgRating(){
        if(getRating()==0){return 0.0F;}else{//consider total is 0,means no number in rating
        return (float) getRating()/ratings.size();}
    }
    // my own add
    public int getNumber(){
        return ratings.size();
    }
    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());//!!!%.1f!!!1
        //Product ID 12345, Laptop, RMB 10000.00, Rating 4.5
    }

    public float getPrice() {
        return price;
    }
}
