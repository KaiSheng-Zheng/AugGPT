import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id=cnt;this.ratings=new ArrayList<>();
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
        ratings.add(rating);return true;
        }else {return false;}
    }
    public float getAvgRating(){
    int a=ratings.size();float sum=0;
        for (int i = 0; i <a ; i++) {
            sum=sum+ratings.get(i);
        }
       if (a>0){float average=sum/a;return average;}else {return 0;}
    }
    public String toString(){
        DecimalFormat decimalFormatPrice=new DecimalFormat("0.00");
        DecimalFormat decimalFormatRating=new DecimalFormat("0.0");
        String b=decimalFormatPrice.format(price);String c=decimalFormatRating.format(getAvgRating());
        String infor=String.format("Product ID %d, %s, RMB %s, Rating %s",id,name,b,c);
        return infor;

    }
}