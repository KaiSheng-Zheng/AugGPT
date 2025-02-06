import java.util.ArrayList;
import java.util.Comparator;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; defaultis empty.
    private Store store;

    public Product(String name, float price) {
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }

    public boolean setRating(int rating){
       if (1<=rating&&rating<=5){
           ratings.add(rating);
           return true;
       }
       else{
           return false;
       }
    }
    public float getAvgRating(){
        if (ratings.size()!=0){
        float sum=0f;
        for (int i = 0; i < ratings.size(); i++) {
            sum+= ratings.get(i);
        }
        return  sum/ratings.size();}
        else {
            return 0;
        }
    }

    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}


class SortByRating implements Comparator<Product> {
    @Override
    public int compare (Product o1 ,Product o2){
        if (o1.getAvgRating()-o2.getAvgRating()<0) {
            return -1;
        }
        if (o1.getAvgRating()-o2.getAvgRating()>0){
            return 1;
        }
       else {
            return 0;
        }
    }
}
class SortByPrice implements Comparator<Product> {
    @Override
    public int compare (Product o1 ,Product o2){
        if (o1.getPrice()-o2.getPrice()>0){
            return 1;
        }
        if (o1.getPrice()-o2.getPrice()<0){
            return -1;
        }
        else {
            return 0;
        }
    }
}
