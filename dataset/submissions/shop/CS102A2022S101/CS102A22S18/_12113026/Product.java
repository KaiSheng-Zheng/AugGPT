import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the 00constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        this.id = ++this.cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating>=1 && rating<=5){
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        int acc = 0;
        for(int r : ratings) {
            acc+=r;
        }

        if (acc==0)
            return 0;

        return (float)acc/ratings.size();
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                id, name, price, getAvgRating());
    }
}
