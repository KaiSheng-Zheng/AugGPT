import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList <Integer> ratings=new ArrayList<>();
    private Store store;
    public float getPrice(){
        return price;
    }

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;                         //??
    }
    public boolean setRating(int rating){
        if(rating>=1&rating<=5){
            ratings.add(rating);
            return true;                                   //??
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        float average=0;
        float sum=0;
        for (int i = 0; i < ratings.size(); i++) {
            sum+=ratings.get(i);
        }
        if(sum!=0) {
            average = sum / ratings.size();
        }
        return average;
    }

    public int getId() {
        return id;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());

       // e.g., Product ID 12345, Laptop, RMB 10000.00, Rating 4.5.

    }


}
