import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private Store store;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if(rating>=1&rating<=5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating() {
        float sum = 0;
        if (ratings.size() == 0) {
            return 0;
        } else {
            for (int a : ratings) {
                sum += a;
            }
            return sum / ratings.size();
        }
    }
    public String toString(){
         return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating() );
    }

    public float getPrice() {
        return price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
