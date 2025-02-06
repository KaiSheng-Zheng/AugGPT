
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        setId(cnt);
        setName(name);
        setPrice(price);

    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }

    public float getAvgRating(){
        float sum = 0;
        if (ratings.size()==0){
            return 0;
        }
        else {
            for (float rating:ratings){
                sum = sum + rating;
            }
            return sum / ratings.size();
            
        }
    }

    public String toString(){
        int price = Math.round(this.price*100);
        StringBuilder change1 = new StringBuilder(Integer.toString(price));
        int length1 = change1.length();
        change1.insert(length1-2,".");
        if (getAvgRating()==0){
            return "Product ID "+id+", "+name+", RMB "+change1+", Rating 0.0";
        }
        else {
            int rating = Math.round(getAvgRating()*10);
            StringBuilder change2 = new StringBuilder(Integer.toString(rating));
            int length2 = change2.length();
            change2.insert(length2-1,".");
            return "Product ID "+id+", "+name+", RMB "+change1+", Rating "+change2;
        }
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }

    public int getId() {
        return id;
    }

}