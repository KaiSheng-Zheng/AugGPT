import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        id = ++ cnt;
        ratings = new ArrayList<>();
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }

    public float getAvgRating(){
        float sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        if (ratings.size() == 0){
            return 0;
        }
        else{
            return sum/ratings.size();
        }
    }


    public String toString(){
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

}
