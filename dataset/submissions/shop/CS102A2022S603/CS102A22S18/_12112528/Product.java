import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private Store productFrom;

    public Store getProductFrom() {
        return productFrom;
    }

    public void setProductFrom(Store productFrom) {
        this.productFrom = productFrom;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
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

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating){
        if (1<=rating&&rating<=5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
         if (ratings.size()==0){
             return 0;
         }
        float sum=0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        return (float) (sum/ratings.size());
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat d = new DecimalFormat("0.0");
       return "Product ID "+id+","+" "+name+","+" RMB "+df.format(price)+","+" Rating "+d.format(getAvgRating());
    }

}
