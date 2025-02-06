import java.util.ArrayList;


public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings =new ArrayList<>();
    private Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){
            this.ratings.add(rating);
            return true;
        }
        else {return false;}
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating(){
        float i=this.ratings.size();float sum=0;
        if(i!=0){
        for (Integer rating : ratings) {
            sum = sum + rating;
        }
        return sum/i;}
        else {return 0;}
    }

    public String toString(){
     return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f" ,id,name,price,getAvgRating());
    }



}