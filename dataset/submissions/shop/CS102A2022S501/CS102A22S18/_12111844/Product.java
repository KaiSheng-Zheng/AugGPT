import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;
    // unique for each product and the value is set to cnt.
    private String name;

    public void setPrice(float price) {
        this.price = price;
    }

    private float price;
    Store store;
    private ArrayList<Integer> ratings = new ArrayList<>();
    // ratings from different customers; default is empty.
    public float getPrice() {
        return price;
    }
    public int getId(){return id;}
    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        id = cnt;
    }
    public boolean setRating(int rating) {
        if (rating>=1 && rating<=5){
            ratings.add(rating);
            return true;
        }
        else
            return false;
    }
    public float getAvgRating(){
        float sum = 0;
        for(Integer rating:ratings){
            sum+=rating;
        }
        if(ratings.size()!=0) {
            return sum / ratings.size();
        } else
            return 0;
    }
    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

}
