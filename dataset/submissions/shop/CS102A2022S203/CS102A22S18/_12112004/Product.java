import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;

    }
    public boolean setRating(int rating){
        if (rating<=5&&rating>=0){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
        int n = ratings.size();
        int sum = 0;
        if (n==0){
            return 0;
        }
        else {
             for (int i = 0 ;i<n;i++){
                 sum = sum + ratings.get(i);
            }
        }
        return sum/ratings.size();
    }

    @Override
    public String toString() {
        StringBuilder S = new StringBuilder();
        DecimalFormat D1 = new DecimalFormat("0.00");
        DecimalFormat D2 = new DecimalFormat("0.0");
        String Price = D1.format(this.price);
        String Rating = D2.format(getAvgRating());
        return "Product ID "+id+","+name+", RMB "+D1.format(this.price)+", Rating "+D2.format(getAvgRating());
    }
}
