import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private int purchasetime;//
    private Store store;

    public void setPurchasetime(int purchasetime) {
        this.purchasetime = purchasetime;
    }
    public int getPurchasetime(){return this.purchasetime;}
    //

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        this.id = ++cnt;
    }
    public float getPrice(){
        return this.price;
    }
    public int getId(){
        return this.id;
    }
    public boolean setRating(int rating){
        if (rating>=1 && rating<=5){
            this.ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        float a = 0;
        if (ratings.size()>0){
            for (int i=0;i<ratings.size();i++){
                a += ratings.get(i);
            }
            double b = a/ratings.size();
            return (float) b;
        }
        else return 0;
    }
    public void setStore(Store store){
        this.store = store;
    }
    public Store getStore(){
        return this.store;
    }
    public String toString(){
        return "Product ID " + id + ", " + name + ", RMB " + String.format("%.2f",price)
                + ", Rating " + String.format("%.1f",getAvgRating());
    }
}
