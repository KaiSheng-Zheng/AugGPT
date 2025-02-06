import java.util.ArrayList;
public class Product {
    private static int cnt =0 ;
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
        else{
            return false;
        }

    }
    public float getAvgRating(){
       int T=0;
        for (int i=0; i<ratings.size();i++){
            T=T+ratings.get(i);

        }
        if (T!=0){
        return (float) T/ratings.size();}
        else{
            return (float)0;
        }
    }

    public String toString(){
        return String.format("Product ID %d, RMB %s, %.2f, Rating %.1f",id,name,price, getAvgRating());
       
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getStore(){
        return store;
    }
    public void setStore(int store){
        this.store=store;
    }
    public float getPrice(){
        return price;
    }



}

