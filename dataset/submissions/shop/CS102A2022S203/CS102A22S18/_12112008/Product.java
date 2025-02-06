

import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    private int pTime;
    private Store belongingStore;

    public int getpTime() {
        return pTime;
    }

    public void setpTime(int pTime) {
        this.pTime = pTime;
    }

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public Store getBelongingStore() {
        return belongingStore;
    }

    public void setBelongingStore(Store belongingStore) {
        this.belongingStore = belongingStore;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            ratings.add(rating);
            return true;
        } else return false;
    }

    public int getId() {
        return id;
    }

    public float getAvgRating() {
        float sum = 0;
        if (ratings.size()!=0){for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        return sum / ratings.size();}
        else return 0.0f;
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

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Float.compare(product.price, price) == 0 && name.equals(product.name) && ratings.equals(product.ratings);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}