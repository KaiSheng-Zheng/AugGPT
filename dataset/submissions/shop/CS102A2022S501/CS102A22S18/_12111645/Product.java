import java.util.ArrayList;

public class Product {
    private static int cnt = 0;       // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;         // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;

    }

    public boolean setRating(int rating) {
        boolean judge;

        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            judge = true;
            this.ratings.add(rating);

        } else {
            judge = false;

        }
        return judge;
    }

    public float getAvgRating() {
        float com = 0;
        float avg;
        for (int i = 0; i < ratings.size(); i++) {
            com = com + ratings.get(i);
        }
        if (ratings.size() == 0) {
            return 0;
        } else {
            avg = com / (float) ratings.size();
            return avg;
        }

    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {

        String a;
        a = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
        return a;

    }

}
