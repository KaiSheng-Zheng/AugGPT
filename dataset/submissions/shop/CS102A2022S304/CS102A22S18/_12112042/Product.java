import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store store;

    public Product(String name,float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
      if(1 <= rating && rating <= 5) {
          this.ratings.add(rating);
          return true;
      }else{
          return false;
      }
    }
    public void setStore(Store store){
        this.store=store;
    }
    public Store getStore(){
        return this.store;
    }
    public String getName() {
        return name;
    }

    public float getAvgRating(){
       float sum = 0;
       if(ratings.size() == 0){
           sum = 0.0f;
           return sum;
       }else{
           for (int i = 0; i < this.ratings.size(); i++) {
               sum = this.ratings.get(i) + sum;
           }
           float avg = sum/(this.ratings.size());
           return avg;
       }
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice() {
        return this.price;
    }
}
