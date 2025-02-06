import java.util.ArrayList;
public class Product {
    private static int cnt ;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private int store;

    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.name = name;
        this.price = price;
    }
    public boolean setRating(int rating){
        if (1<=rating&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        float avgrate=0;
        if(ratings.size()==0) {
            return 0;
        }for (int n=0; n<ratings.size();n++){
            avgrate=avgrate+ratings.get(n);
        }
        return avgrate / ratings.size();
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getStore(){
        return store;
    }

    public float getPrice(){
        return price;
    }
    public void setStore(int store){
        this.store=store;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price, getAvgRating());
    }
}
