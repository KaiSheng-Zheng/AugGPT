import java.text.DecimalFormat;
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
        this.id = cnt;
    }
    
    public void setId(int id) {
        this.id = cnt;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else{return false;}
    }
    public float getAvgRating(){
        if(ratings.size() == 0){
            return 0;
        }else {
            float sum = 0;
            for (int i = 0; i < this.ratings.size(); i++) {
                sum += this.ratings.get(i);
            }
            return (float) (sum / ratings.size());
        }
    }

    public String toString(){
        DecimalFormat money = new DecimalFormat("0.00");
        DecimalFormat Arating = new DecimalFormat("0.0");
//        double Arating=getAvgRating();
//        Arating=Math.round(Arating * 10) / 10f;
//        this.price=Math.round(price * 100) / 100f;
        return("Product ID "+ id+", "+ name +", RMB "+ money.format(price)+", Rating " +
                Arating.format(this.getAvgRating()));
    }
}