import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
        cnt ++;
        id = cnt;
    }

    public boolean setRating(int rating){
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }

    public float getAvgRating(){
        if (ratings.size() == 0){
            return 0;
        }else{
            int[] ratingsNumber = new int[ratings.size()];
            for (int i = 0; i < ratings.size(); i++) {
                ratingsNumber[i] = ratings.get(i);
            }

            float sum = 0;
            for (int j : ratingsNumber) {
                sum += j;
            }

            sum = sum/ratingsNumber.length;
            return sum;
        }

    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice() {
        return price;
    }
}
