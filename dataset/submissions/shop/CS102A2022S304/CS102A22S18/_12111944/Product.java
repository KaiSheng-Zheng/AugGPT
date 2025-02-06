import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Store store;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.id = cnt + 1;
        cnt++;
    }


    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        } else
            return false;
    }

    public float getAvgRating() {
        if (this.ratings.size() == 0) {
            return 0;
        } else {
            float all = 0;
            for (int i = 0; i < this.ratings.size(); i++) {
                all += this.ratings.get(i);
            }
            float avg = all / (float) this.ratings.size();
            return avg;
        }

    }

    public float getPrice() {
        return price;
    }



    public String toString() {
        String rmb = String.format("%.2f", this.price);
        String rate = String.format("%.1f", this.getAvgRating());
        StringBuilder s = new StringBuilder();
        s.append("Product ID ");
        s.append(this.id);
        s.append(", ");
        s.append(this.name);
        s.append(", ");
        s.append("RMB ");
        s.append(rmb);
        s.append(", Rating ");
        s.append(rate);
        return s.toString();
    }
}
