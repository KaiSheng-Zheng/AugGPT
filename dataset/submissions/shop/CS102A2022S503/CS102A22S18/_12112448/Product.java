import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer>ratings;
    public Product(String name,float price){
        cnt++;
        this.name=name;
        this.price=price;
        id= cnt;
        ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating() {
        int sum = 0;
        if (ratings.size() != 0) {

            for (int i : ratings) {
                sum += i;
            }
            float average = (float) sum / ratings.size();
            return average;
        }
        else{
            return 0;
        }
    }
    @Override
    public String toString(){
        StringBuilder result= new StringBuilder();
        result.append("Product ID ");
        result.append(id);
        result.append(", ");
        result.append(name);
        result.append(", RMB ");
        DecimalFormat decimalFormat=new DecimalFormat(".00");
        String pri = decimalFormat.format(price);
        result.append(pri);
        result.append(", Rating ");
        if(getAvgRating()!=0){
        DecimalFormat decimalFormat2=new DecimalFormat(".0");
        String rat = decimalFormat2.format(getAvgRating());
        result.append(rat);}
        else{
            result.append("0.0");
        }
        return String.valueOf(result);
    }
    public float getPrice(){
        return price;
    }
}
