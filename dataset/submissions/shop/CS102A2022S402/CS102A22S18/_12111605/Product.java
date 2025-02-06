import java.util.ArrayList;
import java.util.Comparator;

public class Product {
    private static int cnt = 0;
    private int id;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private String name;
    public Store store;

    public float getPrice() {
        return price;
    }


    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating() {
        double sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        if (ratings.size()==0)return 0;
        else {
            float avg = (float) (sum / ratings.size());
            return avg;
        }

    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Product ID ").append(id).append(", ").append(name).append(", RMB ").append(String.format("%.2f", price))
                .append(", Rating ").append(String.format("%.1f", getAvgRating()));
        return stringBuilder.toString();
    }

}

class compareavgrating implements Comparator<Product> {
    @Override
    public int compare(Product qianmian, Product houmian) {
        if (qianmian.getAvgRating() >= houmian.getAvgRating()) {
            return 1;
        } else return -1;
    }
}

class compareprice implements Comparator<Product> {
    @Override
    public int compare(Product qianmian, Product houmian) {
        if (qianmian.getPrice() > houmian.getPrice()) {
            return 1;
        }  else return -1;
    }
}