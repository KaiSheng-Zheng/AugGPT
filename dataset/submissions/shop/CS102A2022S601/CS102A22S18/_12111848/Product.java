import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;

    Store store;

    public float getPrice() {
        return price;
    }

    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        ++cnt;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
        if(rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        float totalRating = 0;
        for (Integer rating : ratings) {
            totalRating += rating;
        }
        if(ratings.size() != 0) {
            return (totalRating / ratings.size());
        }else {
            return 0;
        }
    }

    public String toString(){
        String str;
        str = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return str;
    }
}
