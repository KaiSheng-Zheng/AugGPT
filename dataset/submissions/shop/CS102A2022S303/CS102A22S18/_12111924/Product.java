
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
        this.ratings=new ArrayList<>();
    }

    public static int getCnt() {
        return cnt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public boolean setRating(int rating){
        if ((rating<=5)&&(rating>=1)){
            this.ratings.add(rating);
            return true;
        }else
            return false;
    }
    public float getAvgRating(){
        int ratingsum=0;
        for (int i = 0; i < ratings.size(); i++) {
            ratingsum+=ratings.get(i);
        }
        if (this.ratings.size()==0){return 0;}
        else if (ratingsum==0){return 0;}
        else return (float) ratingsum /ratings.size();
    }
    public String toString(){
        DecimalFormat df3= new DecimalFormat( "0.0" );
        DecimalFormat df2= new DecimalFormat( "0.00" );
        String q=df2.format(price);
        String d=df3.format(getAvgRating());
        return "Product ID "+id+", "+name+", RMB "+q+", Rating "+d;
    }
}
