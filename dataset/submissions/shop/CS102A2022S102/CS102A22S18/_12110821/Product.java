import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else return false;
    }

    public float getAvgRating(){
       int sum=0;
       for (int x=0;x<ratings.size();x++){
           sum += ratings.get(x);
       }
       if (sum==0){
           return sum;
       }else {return (float)sum/ratings.size();}
    }

    public String toString(){
         return "Product ID "+id+", "+name+", RMB "+new DecimalFormat("0.00").format(price)+
                 ", Rating "+new DecimalFormat("0.0").format(getAvgRating());
    }

}
