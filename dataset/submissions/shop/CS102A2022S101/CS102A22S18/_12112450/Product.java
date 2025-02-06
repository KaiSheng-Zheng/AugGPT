import java.util.ArrayList;
public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    public Product(String name, float price){
        Product.cnt++;
        this.id = Product.cnt;
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
    }
    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public boolean setRating(int rating){
        if (rating>=1&rating<=5) {
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public static int getCnt() {
        return cnt;
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
    public float getAvgRating(){
        float total = 0;
        for(int i=0; i<ratings.size(); i++){
            total = total + ratings.get(i);
        }
        if (ratings.size()>=1)
            total /= ratings.size();
        else
            total=0;
        return total;
    }
    public String toString(){
        return "Product ID "+this.id+", "+this.name+", RMB "+String.format("%.2f", this.price)+", Rating "+ String.format("%.1f", this.getAvgRating());
    }

}
