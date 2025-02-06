import java.util.ArrayList;

public class Product
{
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id ;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private boolean instore = false;// ratings from different customers; default is empty.

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    @Override
    public String toString()
    {
        return "Product ID " + id +
                ", " + name +
                ", RMB " + String.format("%.2f", price) +
                ", Rating " + String.format("%.1f", this.getAvgRating());
    }

    public boolean setRating(int rating)
    {
        if(rating >= 1 && rating <= 5)
        {
            this.ratings.add(rating);
            return true;
        }
        else
            return false;
    }

    public void setInstore(boolean instore) {
        this.instore = instore;
    }

    public float getAvgRating()
    {
        float all = 0;
        for(int rating : ratings)
            all += rating;
        all /= ratings.size();
        return all;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public boolean isInstore() {
        return instore;
    }
}
