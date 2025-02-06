import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price) {
        cnt++;
        this.name = name;
        this.price = price;
        this.id=cnt;
    }

    public boolean setRating(int rating)
    {
        if(rating>=1 && rating<=5)
        {
            this.ratings.add(rating);
            return true;
        }
        else
        {
            return false;
        }
    }

    public float getAvgRating() {
        float sum = 0;
        float av = 0;
        if (ratings.size() >= 1) {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            av = sum / ratings.size();
            return av;
        } else {
            return 0;
        }
    }

    public String toString()
    {
        String x;
        x=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return x;
    }

    public float getPrice() {
        return price;
    }
}