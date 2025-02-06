import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(0);
    Store store ;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        ++cnt;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if (1 <= rating && rating <= 5){
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        if (ratings.size() == 0){
            return 0;
        }
        float sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }

    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice() {
        return price;
    }

}