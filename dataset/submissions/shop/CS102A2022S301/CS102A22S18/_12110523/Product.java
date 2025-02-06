import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings= new ArrayList<Integer>(); // ratings from different customers; default is empty.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id=cnt;

    }
    public boolean setRating(int rating) {
        if (rating<=5&&rating>=1){ratings.add(rating);return true;}
        else {return false;}
    }
    public float getAvgRating(){
        if (ratings.isEmpty()){return 0f;}
       int l= ratings.size();
       float s=0;
       for (int i=0;i<l;i++){
           s+=ratings.get(i);
       }
       s=s/l;
       return s;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());

    }
}
