import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt =0;
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
    public boolean setRating(int rating){
        if (rating>=1 && rating<=5){
            ratings.add(rating);
            return true;
        }else return false;
    }

    public float getAvgRating(){
        int sum =0;
        if (ratings.size()==0){
            return  (float) sum;
        }else {
            for (int value : ratings) {
                sum+=value;
            }
            return  (float) sum/ratings.size();
        }
    }

    public String toString(){
        DecimalFormat fp = new DecimalFormat("0.00");
        DecimalFormat fr = new DecimalFormat("0.0");
        String p = fp.format(price);
        String r = fr.format(getAvgRating());
        return "Product ID "+id+", "+name+", RMB "+p+", Rating "+r;
    }
    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

}
