import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();
    private Store soldFrom;

    public Product(String name, float price) {
        cnt++;
        this.name = name;
        this.price = price;
        id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5)
            return false;
        ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0;
        }
        int total = 0;
        for (int rating : ratings) {
            total += rating;
        }

        return (float) total / (float) ratings.size();
    }


    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name,
                price,
                this.getAvgRating());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public boolean equals(Product product) {
        return product.getId() == this.getId();
    }

    public Store getSoldFrom() {
        return soldFrom;
    }

    public void setSoldFrom(Store soldFrom) {
        this.soldFrom = soldFrom;
    }
}
