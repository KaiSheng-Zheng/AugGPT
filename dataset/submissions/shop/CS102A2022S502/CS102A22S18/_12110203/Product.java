import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer>ratings= new ArrayList<>();
    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.name = name;
        this.price = price;
    }
    public boolean setRating(int rating){
        if(rating>0&&rating<6){
             return ratings.add(rating);
        } else {
            return false;
        }
    }
    public float getAvgRating(){
        if (ratings.size() == 0) return 0.0f;
        int sum=0;
        float av;
        for (Integer rating : ratings) {
            sum += rating;
        }
        av=(float)sum/ratings.size();
        return av;
    }
    @Override
    public String toString(){
        DecimalFormat pf = new DecimalFormat("0.00");
        DecimalFormat rf = new DecimalFormat("0.0");
        String des="Product ID "+id+", "+name+", RMB "+pf.format(this.price)+", Rating ";
        if (this.ratings.size() == 0) {
            des += "0.0";
        } else {
            des += rf.format(getAvgRating());
        }
        return des;
    }
    @Override
    public boolean equals(Object shit) {
        if (shit.getClass() != this.getClass()) {
            return false;
        } else {
            Product product = (Product)shit;
            return product.id == this.id;
        }
    }
    public float getPrice(){
        return this.price;
    }
}