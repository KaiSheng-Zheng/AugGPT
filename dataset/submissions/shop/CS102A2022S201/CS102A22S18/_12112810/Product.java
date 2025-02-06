import java.util.ArrayList;

public class Product {


    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

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

    public Product(String name ,float price){
        id = cnt + 1;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
        cnt ++;

    }




    public boolean setRating(int rating){
        if( rating >= 1 && rating <= 5){
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        float sum = 0;
        for( int i = 0; i < ratings.size(); i++){
            sum = sum + ratings.get(i);
        }
        return sum/ratings.size();
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

}
