
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        cnt = cnt + 1;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
        float avgRating = 0;
        for (int e : this.ratings){
            avgRating = avgRating + e;
        }
        if (this.ratings.size() == 0){
            return 0;
        }
        return avgRating/this.ratings.size();
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public static void main(String[] args) {
        Product a = new Product("labtop",12);
        Product b = new Product("father",22);
        Product c = new Product("labtop",12);
        a.setRating(4);
        a.setRating(3);
        System.out.println(a);
        System.out.println(b);
    }
    public boolean equals(Product product){
        return this.id == product.id;
    }
}
