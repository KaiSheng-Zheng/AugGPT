import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<>();
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
        long total = 0;
        if(ratings.size() != 0) {
            for (int i = 0; i < ratings.size(); i++) {
                total += ratings.get(i);
            }
            float aver = (float) total / ratings.size();
            return aver;
        }else {
            return 0;
        }
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Product product =(Product)obj;
        return Objects.equals(this.id,product.id);
    }

    public float getPrice() {
        return price;
    }
}