import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id=cnt;
        this.ratings=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public boolean setRating(int rating){
        if (rating>=1 && rating<=5){
            ratings.add(rating);

            return true;
        }
        else return false;
    }

    public float getPrice() {
        float a=price*100;
        float b=Math.round(a);
        float c=b/100;
        return c;
    }

    public float getAvgRating(){
        float sum=0;
        for (int i : ratings){
            sum+=i;
        }
        return sum/ratings.size();
    }

    public float getAvgRatingAccurate(){
        float sum=0;
        for (int i : ratings){
            sum+=i;
        }
        float a=(sum/ratings.size())*10;
        float b=Math.round(a);
        float c=b/10;
        return c;
    }

    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRatingAccurate());
    }

}
