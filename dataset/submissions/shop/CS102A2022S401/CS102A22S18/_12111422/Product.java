import java.util.ArrayList;

class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        int[] Rating = new int[ratings.size()];
        for (int i = 0; i < ratings.size(); i++) {
            Rating[i] = ratings.get(i);
        }
        float AvgRating;
        float sum = 0;
        if (ratings.size() != 0) {
            for (int i = 0; i < ratings.size(); i++) {
                sum += Rating[i];
            }
            AvgRating = sum / ratings.size();
        } else {
            AvgRating = 0;
        }
        return AvgRating;
    }

    public String toString() {
        String str1 = null;
        String str2 = null;
        str1 = String.format("%.2f", price);
        float avgRating = this.getAvgRating();
        str2 = String.format("%.1f", avgRating);
        return "Product ID " + id + ", " + name + ", " + "RMB " + str1 + ", " + "Rating " + str2;
    }

    public float getPrice() {
        return price;
    }
}