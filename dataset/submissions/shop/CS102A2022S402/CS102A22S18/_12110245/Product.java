import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
//constructor
    public Product(String name, float price){
        cnt++;
        this.price=price;
        this.name=name;
        this.id=cnt;
    }

//getter and setter

    public float getPrice() {
        return this.price;
    }
    public int getId(){
        return this.id;
    }

    public boolean setRating(int rating){
        if(rating == 1 | rating == 2 | rating == 3 | rating == 4 | rating == 5){
            this.ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }
    public float getAvgRating(){
        int sum=0;
        for(int r:this.ratings){
            sum+=r;
        }
        if(sum==0){
            return 0;
        }
        else{
            return (float) sum/this.ratings.size();
        }
    }
    @Override
    public String toString() {
        DecimalFormat df1 = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0.0");
        return "Product ID " + this.id +
                ", " + this.name +
                ", RMB " + df1.format(this.price) +
                ", Rating " + df2.format(this.getAvgRating());
    }
}
