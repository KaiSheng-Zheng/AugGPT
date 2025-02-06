import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }
            return false;
    }

    public float getAvgRating(){
        if(ratings.size() == 0){
            return 0;
        }else {
            int n = ratings.size();
            int sum = 0;
            for (int d : ratings) {
                sum += d;
            }
            return (float) sum / (float) n;
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

}