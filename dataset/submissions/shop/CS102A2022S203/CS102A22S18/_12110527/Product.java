import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(0);

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }
    public boolean setRating(int rating){
        if(rating <= 5 && rating >= 1) {
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating() {
        if (ratings.size() != 0) {
            float sum = 0;
            float ave = 0.0f;
            for (int i : ratings) {
                sum += (float) i;
            }
            ave = sum / (float) ratings.size();
            DecimalFormat df1 = new DecimalFormat("0.0");
            return Float.valueOf(df1.format(ave));
        }else{
            return  0;
        }
    }

    public float GetAvgRating() {
        if (ratings.size() != 0) {
            float sum = 0;
            float ave = 0.0f;
            for (int i : ratings) {
                sum += (float) i;
            }
            ave = sum / (float) ratings.size();
            return ave;
        }else{
            return  0;
        }
    }

    public String getName() {return name;}
    public int getId() {return id;}
    public float getPrice() {return price;}

    public String toString(){
        DecimalFormat df1 = new DecimalFormat("0.00");
        StringBuilder str = new StringBuilder("");
        str.append("Product ID , , RMB , Rating ");
        str.insert(28,getAvgRating());
        str.insert(19,df1.format(price));
        str.insert(13,name);
        str.insert(11,id);
        return str.toString();
    }
}