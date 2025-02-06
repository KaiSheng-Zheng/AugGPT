import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        this.name=name;
        this.id=cnt;
        this.price=price;
    }

    public boolean setRating(int rating){
        if (rating>0&&rating<=5){
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        float avg = 0;
        if (getRatings().size()==0){
            return 0;
        }
        for (int i = 0; i < getRatings().size(); i++) {
            avg+=getRatings().get(i);
        }
        return avg/getRatings().size();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
    }
}
