import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private Store store;
    private int t;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;

    }
    public void setStore(Store store){
        this.store=store;
    }
    public Store getStore(){
        return this.store;
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        int s=0;
        if (ratings.size()==0){
            return 0;
        }
        else {
        for (Integer a:ratings){
            s+=a.intValue();
        }
      return ((float) s)/(ratings.size());}
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public boolean equals(Product product) {
        return id == product.id && Float.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(ratings, product.ratings);
    }

    public void setPurchaseTime(int a){
        this.t=a;
    }
    public int getPurchaseTime(){
        return this.t;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB ",id,name)+new DecimalFormat("0.00").format(price)+", Rating "+new DecimalFormat("0.0").format(getAvgRating());}

}
