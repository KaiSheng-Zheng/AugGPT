import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private Store store;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name,float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
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

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }else
            return false;
    }

    public float getAvgRating(){
        int sum=0;
        for (Integer rating : this.ratings) {
            sum += rating;
        }if(this.ratings.size()==0){
            return 0;
        }else
            return (float)sum/this.ratings.size();
    }

    public String toString(){
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
    }
}
