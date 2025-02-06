import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;

    }

    public boolean setRating(int rating) {
        if (1 <= rating && rating <= 5) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }


    public float getAvgRating() {
        float sum = 0;

        for (int i=0;i < this.ratings.size();i++) {
            sum = sum + this.ratings.get(i);
        }

        if (sum == 0) {
            return 0;
        } else {
            return sum / this.ratings.size();
        }
    }


    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
