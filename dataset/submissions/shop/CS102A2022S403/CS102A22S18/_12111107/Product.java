import java.util.ArrayList;
public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.

    private int id;  // unique for each product and the value is set to cnt.


    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }
    public int getCnt(){
        return Product.cnt;
    }
    public void setId(int id){
        this.id=cnt+1;
    }
    public int getId(){
        return this.id;
    }

    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.


    private Store store;
    public void setStore(Store store){
        this.store =store;
    }
    public Store getStore(){
        return this.store;
    }
    float average;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice() {
        return this.price;
    }
    private int purchasetime;
    public void setPurchasetime(int purchasetime){
        this.purchasetime= purchasetime;
    }
    public int getPurchasetime(){
        this.purchasetime = purchasetime;
        return purchasetime;
    }
    public Product(String name, float price){
        cnt += 1;
        this.id = cnt;

        this.price =price;
        this.name =name;

    }
    public boolean setRating(int rating){
        if (1<=rating && 5 >= rating){
            ratings.add(rating);
        return true;}
        else return false;
    }
    public float getAvgRating() {
    float sum =0;
        for (int i = 0; i < ratings.size(); i++) {
            sum = sum + ratings.get(i);
        }
        if (ratings.size() == 0) {
            average = 0;
        }
        else {
            average = sum/ratings.size();
    }
        return average;
    }

    public String toString() {
        average = getAvgRating();
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, average);
    }


}
