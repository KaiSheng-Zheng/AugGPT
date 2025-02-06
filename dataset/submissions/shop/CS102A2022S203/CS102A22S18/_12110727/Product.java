import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private int rating;
    private ArrayList<Integer> ratings=new ArrayList<>();


    public static int getCnt() {
        return cnt;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating) {
            if (rating <= 5 && rating >= 1) {
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }



    public float getAvgRating() {
        float sum = 0;
        float c;
        if(ratings.size()!=0) {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);

            }
            c = sum / ratings.size();
        }
        else{
            c=0;
        }
        return c;
        }
        public String toString () {
            return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", getId(), getName(), getPrice(), getAvgRating());
        }
}

