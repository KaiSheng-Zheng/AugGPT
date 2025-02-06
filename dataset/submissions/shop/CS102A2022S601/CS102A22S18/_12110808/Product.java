import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product (String name,float price){
        cnt++;
        this.name=name;
        this.price=price;
        this.id=cnt;
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }
        float l=ratings.size();
        float sum=0;
        for (int i=0;i<l;i++){
            sum+= ratings.get(i);
        }
        return sum/l;
    }
    public String toString(){
        String a=format2(price);
        String b=format1(getAvgRating());
        return String.format("Product ID "+id+","+" "+name+","+" RMB "+a+", "+"Rating "+b);
    }
    public static String format2(float value) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(value);
    }

    public static String format1(float value) {
        DecimalFormat df = new DecimalFormat("0.0");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(value);
    }
    public float getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
}
