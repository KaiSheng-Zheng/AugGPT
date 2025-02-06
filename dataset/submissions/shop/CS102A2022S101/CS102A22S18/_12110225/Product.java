import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product{
    private static int cnt = 0;
    private final int id;
    private final String name;

    private final float price;
    private final ArrayList<Integer> ratings = new ArrayList<>();//must initialize
//    private int ratingSum;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            this.ratings.add(rating);
            return true;
        }else
            return false;
    }
//    public boolean setRating(int rating){
//        ratingSum+=(rating>=1&&rating<=5)?rating:0;
//        return (rating>=1&&rating<=5)?ratings.add(rating):false;
//    }
    public int getId() {
        return id;
    }
    public float getPrice() {
        DecimalFormat df = new DecimalFormat("0.00");
        return Float.parseFloat(df.format(this.price));
    }

    public float getAvgRating(){
        float sum = 0;
        if (this.ratings.size() == 0)
            return 0.0f;
        for (Integer rating : ratings) sum += rating;
        return sum/ratings.size();
    }
    public String toString(){
        DecimalFormat df1 = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0.0");
        return "Product ID " + this.id + ", " + this.name + ", RMB " + df1.format(this.price) + ", Rating "
                + df2.format(this.getAvgRating());
    }
    //
    public int compareTo(Product p,int method){
        if (method == 0){

        }
        if (method == 1){
            if (this.getAvgRating() > p.getAvgRating()) {
                return 1;
            }
            else if (this.getAvgRating() < p.getAvgRating()) {
                return -1;
            }
            else {
                return 0;
            }
        } else if (method == 2){
            if (this.getPrice() > p.getPrice()) {
                return 1;
            }
            else if (this.getPrice() < p.getPrice()) {
                return -1;
            }
            else {
                return 0;
            }
        }
        return 0;
    }
}
