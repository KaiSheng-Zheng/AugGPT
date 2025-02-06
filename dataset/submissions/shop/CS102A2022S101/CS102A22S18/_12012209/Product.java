import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty

    public Product(String name,float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id=cnt;
    }

    public boolean setRating(int rating){
        if(rating >= 1 && rating <= 5)
        {
            ratings.add(ratings.size(), rating);
            return true;
        }
        else return false;
    }

    public float getAvgRating() {
        float sum=0;
        for (int i=0;i<ratings.size();i++) {
            sum += ratings.get(i);
        }
        if(ratings.size()!=0)
        return sum/ratings.size();
        else return 0;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
}
