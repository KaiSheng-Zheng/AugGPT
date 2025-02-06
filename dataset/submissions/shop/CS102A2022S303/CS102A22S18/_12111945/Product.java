import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Store store;
    public int time;

    public int getTime() {
        return time;
    }

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating){
        if (rating>5 || rating<1){
            return false;}
        else {
            ratings.add(rating);
            return true;}}

    public float getAvgRating(){
        if (ratings.size()==0){
            return 0f;
        }
        float sum=0;
        for (int i=0;i<ratings.size();i++){
            sum = sum + ratings.get(i);}
            float avg = sum/ratings.size();
            return avg;}

    public String toString(){
        DecimalFormat pr = new DecimalFormat("0.00");
        DecimalFormat ra = new DecimalFormat("0.0");
        return "Product ID "+this.id+", "+this.name+", "+"RMB "+pr.format(this.price)+", "+"Rating "+ra.format(this.getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public int getId(){
        return id;
    }
}

