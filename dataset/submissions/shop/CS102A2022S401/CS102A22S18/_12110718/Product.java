import java.util.ArrayList;

public class Product {
    private static int cnt = 0;// initialized to 0, and will increase by 1 when the constructor is called.
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        if(ratings.size()==0){
            return 0.0F;
        }else {
            long length = ratings.size();
            int sum = 0;
            for (int x=0;x<length;x++) {
                sum += ratings.get(x);
            }
            return (float) sum/length;
        }
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
