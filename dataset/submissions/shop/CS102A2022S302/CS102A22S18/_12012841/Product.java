import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store store;


    public Product(String name, float price){
        cnt++;
        this.name=name;
        this.price=price;
        this.id=cnt;
        this.ratings=new ArrayList<>();
    }

    public boolean setRating(int rating){
    if (rating>=1&&rating<=5){
          ratings.add(rating);
          return true;
          }else{return false;}
    }

    public float getAvgRating(){
    float sum=0;
        for (int i = 0; i < ratings.size(); i++) {
            sum+=ratings.get(i);
        }
        return sum/ratings.size();

    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
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

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public String toString(){
        return "Product ID " +id
                +", "+name
                + ", RMB "+BigDecimal.valueOf(price).setScale(2).toString()
                +", Rating "+getAvgRating();

    }


}
