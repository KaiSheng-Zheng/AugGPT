
import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>(); // ratings from different customers; default is empty.
    private int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id=cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if(1<=rating&&rating<=5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        int sum=0;
        if(ratings.size()==0){
            return 0;

        }
        for (int i = 0; i < ratings.size(); i++) {
            sum= ratings.get(i)+sum;
        }
        float average=(float) sum/ratings.size();
        return average;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,Math.round(price*100)*0.01,Math.round(getAvgRating()*10)*0.1);
    }
}

