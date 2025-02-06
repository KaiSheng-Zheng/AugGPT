import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating==1||rating==2||rating==3||rating==4||rating==5) {
            this.ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating() {
        float sum = 0;
        if (this.ratings.size()==0) {
            return 0;
        }else {
            for (int i = 0; i < this.ratings.size(); i++) {
                sum += this.ratings.get(i);
            }
            return sum / this.ratings.size();
        }
    }

    public String toString() {
        String re = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
        return re;
    }

    public float getPrice() {
        return price;
    }
}
