import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class Product {
    //Attributes
    private static int cnt = 0;

//    public int getId() {
//        return id;
//    }

    public int getId() {
        return id;
    }

    private int id;
    private String name;

    public float getPrice() {
        return price;
    }

    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    //Constructor
    public Product(String name, float price) {
        cnt++;
        this.name = name;
        this.id = cnt;
        this.price = price;
//        this.ratings=;
    }

    //Methods
    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
//        float sum = 0;
//        if (ratings.size() == 0) {
//            return 0.0F;
//        } else {
//            float[] F = new float[ratings.size()];
//            for (int i = 0; i < ratings.size(); i++) {
//                F[i] = ratings.get(i);
//                sum = sum + F[i];
//            }
////            String k = String.valueOf(sum / ratings.size());
//
//
//                return (float) (Math.round(sum / ratings.size() * 10)) / 10;

            int sum = 0;
            float av = 0;
            if(ratings.size()!=0) {
                for (int i = 0; i < ratings.size(); i++) {
                    sum += ratings.get(i);
                }
                av = (float) sum/ratings.size();
            }
            return av;


        }



//        String k=String.format("%.1f",sum/ratings.size());

//        return Float.valueOf(k);}
//        String k=String.valueOf(sum/ratings.size());
//        if (k.length()>3){
//        StringBuffer sb=new StringBuffer(k);
//        k=sb.substring(0,3);
//        return Float.valueOf(k);
//        }
//        else if
//DecimalFormat df=new DecimalFormat("0.00");
//        float result=new BigDecimal(k).setScale(1,BigDecimal.ROUND_HALF_UP).floatValue();
//        return Float.parseFloat(new DecimalFormat("0.0").format(sum/ratings.size()));



//    public String toString1(){
//        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
//
//    }

    public String toString() {
        String price2 = String.format("%.2f", this.price);
        String average = String.format("%.1f",getAvgRating());
        String a = "Product ID " + this.id + ", " + this.name + ", RMB " + price2 + ", Rating " +average ;
        return a;
    }



}























