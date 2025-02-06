import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price=0;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        this.name = name;
        if (price>0){
        this.price = price;
        }
        cnt++;
        this.id = cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating>=1 && rating <=5){
            return this.ratings.add(rating);
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum = 0;
        int count = this.ratings.size();
        if (count!=0){
        for (int i=0; i<count; i++){
            sum = sum + ratings.get(i);
        }
        return sum/count;}
        else{
            return 0;
        }
    }

   @Override
   public String toString(){
        return "Product ID"+" "+ id+", "+ name+ ", "+ "RMB"+" "+ String.format("%.2f", price)+", "+ "Rating"+" "+String.format("%.1f",getAvgRating());
   }
}
