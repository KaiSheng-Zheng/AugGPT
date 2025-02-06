import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Store ls = null;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        this.ratings  = new ArrayList<>();
        cnt++;
        id = cnt;
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else
            return false;
    }
    public float getAvgRating(){
        if (ratings==null)return 0;
        else {
            float n=0;
            for (int i=0;i<ratings.size();i++){
                n += ratings.get(i);
            }
            if (n==0)return 0;
            else {
                n = n/ratings.size();
                return n;
            }

        }
    }
    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());

    }

    public int getId() {
        return this.id;
    }

    public float getPrice() {
        return this.price;
    }
}