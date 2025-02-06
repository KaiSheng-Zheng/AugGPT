import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;;
    private ArrayList<Integer> ratings=new ArrayList<>();; // ratings from different customers; default is empty.

    public int getId(){
        return id;
    }
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean equals(Product p1){
        if(id==p1.id&&price==p1.price&&name.equals(p1.name)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setRating(int rating){
        if(rating<6&&rating>0){
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }
    public float getAvgRating(){
        float ans=0;
        for(int i=0;i<ratings.size();i++){
            ans+=ratings.get(i);
        }
        if(ratings.size()!=0){
            ans=ans/ratings.size();
        }
        return ans;
    }
    public String toString(){
        DecimalFormat df1 = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0.0");
        String ans="Product ID "+id+", "+name+", RMB "+df1.format(price)+", Rating "+df2.format(getAvgRating());
        return ans;
    }
}
