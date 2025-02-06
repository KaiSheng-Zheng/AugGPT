import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    public Store store;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        this.id = ++cnt ;
        this.name = name ;
        this.price = price ;
    }

    public boolean setRating(int rating){
        boolean j = false ;
        if(rating >= 1 && rating <= 5){
            ratings.add(rating) ;
            j = true;
        }
        return j;
    }

    public float getAvgRating(){
        float len = ratings.size() ;
        float sum = 0 ;
        float avg = 0 ;
        if(len==0){
            avg = 0;
        }
        else{
            for (int i = 0; i < len; i++) {
                sum = sum + ratings.get(i) ;
            }
            avg = sum/len;
        }
        return avg ;
    }

    public String toString(){
        String s = "";
        s = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name,price, getAvgRating() );
        return s;
    }

    public String getName() {
        return name;
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