import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
        if (rating<1||rating>5){
            return false;
        }else {
            ratings.add(rating);
            return  true;
        }
    }



    public float getAvgRating() {
        float sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum = sum + ratings.get(i);
        }
        float avg = 0;
        if (ratings.size() != 0) {
            avg = sum / ratings.size();
        }
        return avg;
    }
    public float getPrice(){
        return price;
    }

    public String toString(){
        DecimalFormat price1 = new DecimalFormat("0.00");
        DecimalFormat avgRating = new DecimalFormat("0.0");
        String str1 ="Product ID "+id+", "+name+", RMB "+price1.format(price)+", Rating "+avgRating.format(getAvgRating());
        return str1;
    }
}
