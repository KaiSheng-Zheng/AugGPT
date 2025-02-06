import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id = 0;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store store;
    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.ratings=new ArrayList<>();
        this.store=null;
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating) {
        boolean b = false;
        if(rating==1||rating==2||rating==3||rating==4||rating==5){
            b=true;
            ratings.add(rating);
        }
        return b;
    }
    public float getAvgRating(){
        float avg=0.0f;
        float sum=0.0f;
        if(ratings.size()==0){
            avg=0;
        }else{
        for (int i:ratings
             ) {
            sum+=i;
        }
        avg=sum/ratings.size();
        }
        return avg;
    }
    public String toString(){
        return  String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }
}
