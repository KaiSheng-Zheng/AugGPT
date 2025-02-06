import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private Store store;
    private int soldTime;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public int getSoldTime() {
        return soldTime;
    }

    public void setSoldTime(int soldTime) {
        this.soldTime = soldTime;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Product(String name, float price){
        ratings = new ArrayList<>();
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating){
        if (rating < 1 || rating > 5) return false;
        ratings.add(rating);
        return true;
    }

    public float getAvgRating(){
        int size = ratings.size();
        if (size == 0) return 0f;
        float sum = 0;
        for (int temp : ratings){
            sum += temp;
        }
        return sum/size;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                id, name, price, getAvgRating());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
