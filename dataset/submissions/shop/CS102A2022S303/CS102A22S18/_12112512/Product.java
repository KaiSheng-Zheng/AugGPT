import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store from;

    public Store getFrom() {
        return from;
    }

    public void setFrom(Store from) {
        this.from = from;
    }

    public Product(String name, float price){
        cnt = cnt + 1;
        this.name = name;
        this.price = price;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }
    public boolean setRating(int rating) {
        if(rating==1||rating==2||rating==3||rating==4||rating==5){
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }
    public float getAvgRating(){
        if(ratings.size()==0){
            return 0;
        }else{
        float a = 0;
        for(int i = 0; i<=ratings.size()-1; i++){
            a = a + ratings.get(i);
        }
        return a/ratings.size();
        }

    }
    public String toString(){
        BigDecimal a1 = new BigDecimal(price);
        a1 = a1.setScale(2, RoundingMode.HALF_UP);
        BigDecimal a2 = new BigDecimal(getAvgRating());
        a2 = a2.setScale(1, RoundingMode.HALF_UP);
        String a = "Product ID "+id+", "+name+", RMB "+a1+", Rating "+a2;
           return a;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
