import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;

    private ArrayList<Integer> ratings = new ArrayList<>();


    public Product(String name, float price) {
        cnt++;
        this.name = name;
        this.price = price;
        id = cnt;
    }


    public float getprice(Product a){
        return a.price;
    }

    public boolean setRating(int rating) {
        if (rating != 1 && rating != 2 && rating != 3 && rating != 4 && rating != 5) {
            return false;
        } else {
            ratings.add(rating);
            return true;
        }
    }


    public float getAvgRating() {
        float sum = 0;
        float x;
        if (ratings.size() == 0) {
            x = 0;
            return x;
        } else {
            for (int i = 0; i < ratings.size(); i++) {
                float a = ratings.get(i);
                sum += a;
            }
            x = sum / ratings.size();
            return x;
        }
    }


    public String toString() {
        String a = "";
        float x= (float) Math.round((price*100)/100);
        float y= (float) Math.round((getAvgRating()*10)/10);
        return String.format("Product ID " + "%d" + ", " + "%s" + ", RMB " + "%.2f" + ", Rating " + "%.1f",id,name,x,y );
    }
}
