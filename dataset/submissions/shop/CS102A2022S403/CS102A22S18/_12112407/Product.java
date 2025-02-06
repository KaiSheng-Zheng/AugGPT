import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private Store store;
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }

    public void setStore(Store store){
        this.store=store;
    }

    public Store getStore() {
        return store;
    }

    public boolean setRating(int rating){
        if (rating<1||rating>5){
        return false;
        }
        else {
            ratings.add(rating);
            return true;
        }
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating(){
        float sum=0;
        if (ratings.size()!=0){
        for (int i:ratings){
            sum=sum+i;
        }
        return sum/ratings.size();
        }
        else return 0;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
