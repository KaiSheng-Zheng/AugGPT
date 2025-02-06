import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        Product.cnt++;
        this.id = Product.cnt;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        } else {
           return this.ratings.add(rating);
        }
    }

    public float getAvgRating() {
        if (this.ratings.size()==0) {
            return 0.0f;
        } else {
            float avg = 0;
            for (int i = 0; i < ratings.size(); i++) {
                avg += ratings.get(i);
            }
            return avg / this.ratings.size();
        }

    }

    public String toString() {
        if (this.ratings.size() == 0) {
            return String.format("Product ID %d, %s, RMB %.2f, Rating 0.0", this.id, this.name, this.price);
        } else {
            return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, getAvgRating());
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }
}
