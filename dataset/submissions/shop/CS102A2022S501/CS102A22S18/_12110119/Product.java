
import java.util.ArrayList;
public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    public int storenumber=0;
    public Store from=new Store();
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;

    };
    public float getPrice(){
        return price;
    }
    public boolean setRating(int rating) {
        switch (rating) {
            case 1:
                ratings.add(rating);
                return true;
            case 2:
                ratings.add(rating);
                return true;
            case 3:
                ratings.add(rating);
                return true;
            case 4:
                ratings.add(rating);
              return true;
            case 5:
                ratings.add(rating);
                return true;
            default:
                return false;
        }

    }
    public float getAvgRating(){
        int t=ratings.size();
        float total=0;
        if(ratings.size()==0){
            return 0.0f;
        }
        for(int ti=0;ti<t;ti++){
            total+=ratings.get(ti);
        }
        return (total/(float) t);
    };
    public String toString(){
       return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating()) ;
    };

}
