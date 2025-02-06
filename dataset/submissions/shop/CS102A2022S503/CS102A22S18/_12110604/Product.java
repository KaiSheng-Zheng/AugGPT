import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private Store store;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.


    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }

    public float getPrice() {
        return price;
    }

    public Store getStore(){
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum=0;
        for (Integer rating : ratings) {
            sum += rating;
        }if (ratings.size()!=0) {
            float ret;
            ret = sum / ratings.size();
            return ret;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Product ID "+id+", "+name+", RMB "+ String.format("%.2f", price) +
                ", Rating " + String.format("%.1f", getAvgRating())
                ;
    }
}
