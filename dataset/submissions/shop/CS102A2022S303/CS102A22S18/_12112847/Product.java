import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private Store store;
    private int buy;

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product(String name, float price){
        this.name=name;this.price=price;
        cnt++;
        this.id=cnt;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){ratings.add(rating);return true;}else{return false;}
    }
    public float getAvgRating(){
        float a=0;
        for (int i = 0; i < ratings.size(); i++) {
            a+=(float)ratings.get(i);
        }
        if(ratings.size()!=0){
        a/=(float) ratings.size();
        return a;
        }else{
            return 0.0F;
        }
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice() {
        return price;
    }




}
