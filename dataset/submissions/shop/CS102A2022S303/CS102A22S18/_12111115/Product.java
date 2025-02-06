import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private Store store;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if (1<=rating && rating<=5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        float sum=0;
        float avg ;
        for (int i = 0; i < ratings.size(); i++) {
            sum=sum+ratings.get(i);
        }
        if (ratings.size()==0){
            avg=0;
        }else {
            avg = sum/ratings.size();
        }
        return avg;
    }

    public String toString(){
        String ID = "Product ID "+this.id;
        String RMB = "RMB " +String.format("%.2f",this.price);
        String RAT = "Rating "+String.format( "%.1f",getAvgRating() );
        return ID+", " + this.name+", "+RMB+", "+RAT;
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
}
