import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();;
    private int storeid;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
     }
    public boolean setRating(int rating){
        if(rating > 5 || rating < 1){
            return false;
        }
        ratings.add(rating);
        return true;

    }
    public float getAvgRating(){
        float avrRating = 0.0f;
        float sum = 0.0f;
        for(int i = 0;i < ratings.size();i++)
        {
            sum += ratings.get(i);
        }
        if(ratings.size() ==0){
            return 0.0f;
        }
        avrRating = sum/ratings.size();
        return avrRating;

    }
    public String toString(){
        String st = "Product ID "+ String.valueOf(id)+", "+name+", RMB "+String.format("%.2f",price)+
                ", Rating "+String.format("%.1f",getAvgRating());
        return st;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public int getStoreid() {
        return storeid;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }
}
