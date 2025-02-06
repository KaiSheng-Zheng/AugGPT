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
        cnt++;
        this.id = cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        float a = 0;
        if (ratings.size() != 0) {
            for (Integer rating : ratings) {
                a = a + rating;
            }
            return a / ratings.size();
        }else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        StringBuilder e = new StringBuilder();
        String b;
        String c = String.format("%.1f", getAvgRating());
        String d = String.format("%.2f", price);
        e.append("Product ID ");
        e.append(id);
        e.append(", ");
        e.append(name);
        e.append(", RMB ");
        e.append(d);
        e.append(", Rating ");
        e.append(c);
        return e.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product p = (Product) o;
        return id == p.id;
    }

}
