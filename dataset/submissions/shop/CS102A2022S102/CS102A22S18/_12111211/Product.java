

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

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
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
        int sum = 0;
        float average = 0;
        if(ratings.size()!=0) {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            average = (float) sum/ratings.size();
        }
        return average;
    }

    public String toString() {
        String price2 = String.format("%.2f", this.price);
        String average = String.format("%.1f",getAvgRating());
        String a = "Product ID " + this.id + ", " + this.name + ", RMB " + price2 + ", Rating " +average ;
        return a;
    }

}

