import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id; // unique for each product and the value is set to cnt.
    private final String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store belongTo;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        ++cnt;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }

    public void setBelongTo(Store store) {
        belongTo = store;
    }

    public Store getBelongTo() {
        return belongTo;
    }

    public boolean setRating(int rating) {
        switch (rating) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: {
                ratings.add(rating);
                return true;
            }
            default:
                return false;
        }
    }

    public float getAvgRating() {
        if (ratings.size() == 0){
            return 0f;
        }
        float sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
