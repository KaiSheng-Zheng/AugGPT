import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }


    public boolean setRating(int rating) {
        boolean p = true;
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
        } else {
            p = false;
        }
        return p;
    }

    public float getAvgRating() {
        float a = 0;
        int sum = 0;
        if (ratings.size() != 0) {
            for (int j : ratings
            ) {
                sum += j;

            }
            a = (float) sum / ratings.size();
        }
        return a;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, getAvgRating());
    }
}
