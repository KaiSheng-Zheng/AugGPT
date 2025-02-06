import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private Store ItsStore;
    public Product(String name,float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){ratings.add(rating);return true;}
        else return false;
    }
    public float getAvgRating(){
       float sum=0;
       if(ratings.size()==0)return 0;
        for(int a:ratings){
            sum+=a;
        }
        return sum/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public Store getItsStore() {
        return ItsStore;
    }

    public void setItsStore(Store itsStore) {
        ItsStore = itsStore;
    }
}