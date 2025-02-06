import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private Store store;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt = cnt+1;
        id = cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }
public void setStore(Store store){this.store = store;}
    public float getPrice() {
        return price;
    }
    public String getName(){
        return name;
    }
    public boolean setRating(int rating){
        if (rating==1|rating==2|rating==3|rating==4|rating==5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        int total=0;
        if (ratings.size()!=0) {
            for (int i = 0; i < ratings.size(); i++) {
                total = total + ratings.get(i);
            }
            return (float) total / ratings.size();
        }else{
            return 0;
        }
    }
    public String toString(){
        String a = String.format("%.2f",price);
        String b = String.format("%.1f",getAvgRating());
        return "Product ID "+id+", "+name+", RMB "+a+", Rating "+b;
    }
}
