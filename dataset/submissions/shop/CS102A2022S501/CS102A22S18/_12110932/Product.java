import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id=0;  // unique for each product and the value is set to cnt.
    private String name="";
    private float price=0;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public static void main(String[] args) {}
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }else return false;
    }
    public float getAvgRating() {
        float sum=0;
        if(this.ratings.size()==0) return 0;
        for(int i=0;i<this.ratings.size();i++){
            sum=sum+this.ratings.get(i);
        }
        sum=sum/this.ratings.size();
        return sum;
    }
    public String toString(){
        double f= price;
        double e= this.getAvgRating();
        //float f = 0.5555f;
        DecimalFormat df1 = new DecimalFormat("0.00");
        //df1.format(f);
        DecimalFormat df2 = new DecimalFormat("0.0");
        //df1.format(f);
        String s="Product ID "+id+", "+name+", RMB "+df1.format(f)+", Rating "+df2.format(e);
        return s;
        //Math.round(price* 100) / 100f
    }
    public float getprice(){
        return this.price;
    }
    public int getId(){
        return this.id;
    }
}
