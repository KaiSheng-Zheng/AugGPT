import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private float avgRating;

    public Product(String name, float price) {
        id = ++cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
        avgRating = 0;
    }

    public boolean setRating(int rating){
        if (1<=rating&&rating<=5){
            ratings.add(rating);
            avgRating = (avgRating*(float) (ratings.size()-1) + rating)/ ratings.size();

            return true;
        }
        return false;
    };
    public float getAvgRating(){
        float cnt = 0;
        for (int i :
                ratings) {
            cnt+=i;
        }
        return cnt/ratings.size();
    };

    public float getPrice() {
        return price;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, Math.round(price * 100.0)/100.0, Math.round(getAvgRating()*10.0)/10.0) ;
    };

}
