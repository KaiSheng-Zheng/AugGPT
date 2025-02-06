import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        float sum=0;
        if (ratings.size()>0){
        for (Integer rating : this.ratings) {
            sum += rating;
        }
        return sum/this.ratings.size();}
        else return sum;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",Math.abs(this.id),this.name,this.price,this.getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}