import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        float avg=0;
        if (ratings.size()==0){
            avg=0;
        }
        else {
            for (Integer rating : ratings) {
                avg += rating;
            }
            avg/=ratings.size();
        }
        return avg;
    }
    public String toString(){
        String s1=String.format("%.2f",price);
        String s2=String.format("%.1f",getAvgRating());
        return "Product ID "+id+", "+name+", RMB "+s1+", Rating "+s2;
    }
    public float getPrice() {
        return price;
    }
}