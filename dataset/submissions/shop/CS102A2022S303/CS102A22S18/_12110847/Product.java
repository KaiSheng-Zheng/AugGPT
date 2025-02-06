import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price){
        id=++cnt;
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5)
            return ratings.add(rating);
        return false;
    }

    public float getAvgRating(){
        float sum=0;
        for (int i=0;i<ratings.size();i++) {
            sum += ratings.get(i);
        }
        if (ratings.size()==0){
            return 0;
        }else
        return sum/ratings.size();
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public int getId(){
        return id;
    }
    public float getPrice(){
        return price;
    }

    public boolean equals(Product p){
        if(p.getId()==id)
            return true;
        return false;

    }

}