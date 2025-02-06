import java.text.DecimalFormat;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }


    public boolean setRating(int rating){
        if ((rating == 1) || (rating == 2) || (rating == 3) || (rating == 4) || (rating == 5)) {
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }


    public float getprice() {
        BigDecimal a = new BigDecimal(price);
        float b = a.setScale(2, BigDecimal.ROUND_UP).floatValue();
        return b;
    }


    public String getprice1() {
        String formatStr = "0.";
        for(int i=0;i<2;i++){
            formatStr = formatStr + "0";
        }
        return new DecimalFormat(formatStr).format(price);
    }
    public int getId() {return id;}


    public float getAvgRating(){
        float sum = 0.000000000F;
        if (ratings.size() == 0) {
            return 0.0F;
        }
        else {
        for (int i = 0; i < ratings.size(); i++) {
            sum = sum + ratings.get(i);
        }
        if (sum/ratings.size() == 0.0F) {
            return 0.0F;
        }
        else if (sum/ratings.size() == 1.0F) {
            return 1.0F;
        }
        else if (sum/ratings.size() == 2.0F) {
            return 2.0F;
        }
        else if (sum/ratings.size() == 3.0F) {
            return 3.0F;
        }
        else if (sum/ratings.size() == 4.0F) {
            return 4.0F;
        }
        else if (sum/ratings.size() == 5.0F) {
            return 5.0F;
        }
        else {
        BigDecimal a = new BigDecimal(sum/ratings.size());
        float b = a.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        return b;
        }
        }
    }


    public float getAvgRating1(){
        float sum = 0.0F;
        if (ratings.size() == 0) {
            return 0.0F;
        }
        else {
            for (int i = 0; i < ratings.size(); i++) {
                sum = sum + ratings.get(i);
            }
            float average = (float)(Math.round(sum/ratings.size() * 1000000000)) / 1000000000;
            return average;
        }
    }

    public String toString(){
        String result = "Product ID" + " " + id + ", " + name + ", RMB " + getprice1() + ", Rating " + getAvgRating();
        return result;
    }
}
