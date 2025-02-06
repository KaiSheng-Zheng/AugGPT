import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating) {
        if(rating==1||rating==2||rating==3||rating==4||rating==5){
            ratings.add(rating);
            return true;
        }else
            return false;
    }

    public float getAvgRating(){
        float sum=0;
        for(int i=0;i<ratings.size();i++){
            sum+=ratings.get(i);
        }
        float av;
        if(ratings.size()!=0)av=sum/ratings.size();
        else av=0;
        return av;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String strPrice = decimalFormat.format(price);
        DecimalFormat decimalFormat1 = new DecimalFormat("0.0");
        String a = decimalFormat1.format(getAvgRating());
        return "Product ID " +
                 + id +
                ", " + name  +
                ", RMB " + strPrice +
                ", Rating " + a ;
    }

}
