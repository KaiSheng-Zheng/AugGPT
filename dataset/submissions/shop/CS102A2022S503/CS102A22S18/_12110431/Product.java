
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }

    public boolean setRating(int rating){
        boolean b=rating<=5&&rating>=1;
        if (b){
            ratings.add(rating);
        }return b;
    }

    public float getAvgRating(){
        int length= ratings.size();
        if (length==0){return 0;}
        int sum=0;
        for (int i=0;i<ratings.size();i++){
            sum=sum+ratings.get(i);
        }
        return (float) sum / length;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,this.getAvgRating());
    }

    public int getId(){
        return id;
    }

    public float getPrice(){return price;}

}

