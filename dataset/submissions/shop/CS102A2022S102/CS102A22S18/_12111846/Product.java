import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if(rating <6 && rating >0){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }

    public float getAvgRating(){
        int sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        float avgRating ;
        if(ratings.size() == 0 ){
            avgRating = 0 ;
        }else{
            avgRating = (float) sum/ratings.size();
        }
        return avgRating;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}