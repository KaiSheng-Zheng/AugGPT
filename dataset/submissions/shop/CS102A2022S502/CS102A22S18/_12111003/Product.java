import java.util.ArrayList;

public class Product {
    // Attributes
    private static int cnt;  // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id; // unique for each product and the value is set to cnt..
    private final String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty
    // Constructor
    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.ratings = new ArrayList<>(){};
        if (price > 0) this.price = price;
    }
    public float getPrice() {return price;}
    // Methods
    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        } else return false;
    }
    public float getAvgRating() {
        float AllRating = 0, AvgRating;
        if (this.ratings.size() == 0) AvgRating = 0;
        else {
            for (Integer rating : this.ratings) {
                AllRating += rating;
            }
            AvgRating = AllRating / this.ratings.size();
        }
        return AvgRating;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String Prise = String.format("%.2f", this.price);
        String Rating = String.format("%.1f", getAvgRating());
        stringBuilder
                .append("Product ID ")
                .append(this.id)
                .append(", ")
                .append(this.name)
                .append(", RMB ")
                .append(Prise)
                .append(", Rating ")
                .append(Rating);
        return stringBuilder.toString();
    }
}
