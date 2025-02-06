import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }
    public boolean setRating(int rating){
        if(1<=rating&&rating<=5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        float avg = 0;
        for (int i = 0; i < ratings.size(); i++) {
            avg = avg+ratings.get(i);
        }
        if(ratings.size()==0){
            return 0;
        }else{
            avg = avg/ratings.size();
            return avg;
        }

    }
    public String toString(){
        String s1 = String.format("Product ID "+id+", "+name);
        String s2 = String.format(", RMB %.2f",price);
        String s3 = String.format(", Rating %.1f",getAvgRating());
        return s1+s2+s3;
    }
    public float getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
}
