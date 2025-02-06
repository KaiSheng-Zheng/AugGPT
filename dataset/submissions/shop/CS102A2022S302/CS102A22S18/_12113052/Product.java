import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();//customers' comments

    public Product(String name, float price) {
        cnt++;//increase by 1 when the constructor is called
        this.id=cnt;
        this.name = name;
        this.price = price;
        this.ratings=new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (rating>0&&rating<6){
            ratings.add(rating);
            return true;
        }else return false;
    }

    public float getAvgRating(){
        int sum=0;
        if (ratings.size() ==0) return 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum+=ratings.get(i);
        }
        float average=(float) sum/ratings.size();
        return average;
    }

    public float getPrice(){
        return price;
    }

    public String toString(){
        DecimalFormat priceFormat=new DecimalFormat("0.00");
        DecimalFormat averageRatingFormat=new DecimalFormat("0.0");
        return "Product ID "+this.id+", "+this.name+", RMB "+priceFormat.format(this.price)+
                ", Rating " +averageRatingFormat.format(this.getAvgRating());
    }
}
