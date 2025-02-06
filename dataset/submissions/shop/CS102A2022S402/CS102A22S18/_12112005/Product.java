import java.util.ArrayList;

public class Product {
    private static int cnt =0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<Integer>();
    }

    public boolean setRating(int rating){
        if(rating>=1 && rating<=5){
            this.ratings.add(rating);
            return true;
        }else return false;
    }

    public float getAvgRating(){
        float average;
        int l = this.ratings.size();
        if(l==0){
            average=0;
            return average;
        }
        int sum =0;
        for(int i=0;i<l;i++){
            sum+=this.ratings.get(i);
        }
        average = (float) sum/l;
        return average;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
    }

    public float getPrice(){
        return this.price;
    }

    public int getId() {
        return this.id;
    }
}
