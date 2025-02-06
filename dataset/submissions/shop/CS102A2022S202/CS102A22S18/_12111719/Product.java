import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        float sum=0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        if (ratings.size()==0){
            return 0;
        }
        return sum/ratings.size();
    }
    @Override
    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }
}