import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty
    private Store store;
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
        ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum =0;
        if(ratings.size()==0){
            return 0;
        }
       else{ for (int i = 0; i < ratings.size(); i++) {
           sum=sum+ratings.get(i);
        }
        return  (sum/(float)ratings.size());
       }
    }
    public String toString(){
        String answer=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return answer;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }


}
