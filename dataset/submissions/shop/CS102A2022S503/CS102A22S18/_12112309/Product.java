import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;


    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price){
        float num=price;
        this.price=price;
        this.name=name;
        cnt++;
        id=cnt;
    }
    public static int getCnt() {
        return cnt;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public int getId() {
        return id;
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }

    public float getAvgRating(){
        int num = 0;
        if(this.ratings.size()==0){
            return 0;
        }
        for (int rating : this.ratings) {
            num += rating;
        }
        return (float) ((double)num / ((double) this.ratings.size()));
    }

    @Override
    public String toString() {
        return
          "Product ID " + id +", "+ name  + ", RMB " + String.format("%.2f",getPrice()) + ", Rating " + String.format("%.1f",getAvgRating());

    }
}
