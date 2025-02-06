import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name,float price){
        this.name=name;this.price=price;Product.cnt++;this.id=Product.cnt;
    }
    public boolean setRating(int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){this.ratings.add(rating);return true;}
        else return false;
    }
    public float getAvgRating(){
        float Sum=0.0f;
        if (ratings.size()>0) {for (int n:ratings){Sum+=n;}
        return (Sum/(ratings.size()));}
        else return 0;}
    public String toString(){
        DecimalFormat decimalFormat =new DecimalFormat("0.00");
        DecimalFormat decimalFormat1=new DecimalFormat("0.0");
        return "Product ID "+id+", "+name+", RMB "+ decimalFormat.format(price)+", Rating "+decimalFormat1.format(getAvgRating());
    }
    public float getPrice(){return price;}
    public int getId(){return id;}
}