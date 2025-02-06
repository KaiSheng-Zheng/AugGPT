import java.util.ArrayList;

public class Product{
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (rating >=1 && rating <=5){
            this.ratings.add(rating);
            return true;
        }else return false;
    }


    public float getAvgRating(){
        float r = 0;
        for (Integer rating : ratings) {
            r += rating;
        }
        if (ratings.size() == 0){
            return 0;
        }else return r / ratings.size();

    }
    public int getId(){
        return id;
    }
    public float getPrice(){
        return price;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}


