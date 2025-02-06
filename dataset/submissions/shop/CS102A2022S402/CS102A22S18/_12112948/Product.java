import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {

    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();


    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5) {
            ratings.add(rating);
            return true;
        }
        else
            return false;
    }

    public float getAvgRating(){
        float sum=0;
        if (ratings.size()==0){
            return 0;
        }
        for (int i=0;i<ratings.size();i++){
            sum=sum+ratings.get(i);
        }
        float average=sum/ratings.size();
        return average;
    }

    public String toString(){
        DecimalFormat decimalFormat1=new DecimalFormat("0.00");
        String p=decimalFormat1.format(price);
        DecimalFormat decimalFormat2=new DecimalFormat("0.0");
        String avg=decimalFormat2.format(getAvgRating());
        return "Product ID "+id+", "+name+", RMB "+p+", Rating "+ avg;
    }

}
