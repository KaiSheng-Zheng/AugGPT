import java.util.ArrayList;
public class Product {
    private static int cnt ;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt += 1;
        this.id =cnt;
    }
    public boolean setRating(int rating){
        if(1<= rating && rating <=5){
            this.ratings.add(rating);
            return true;
        }
        else
        return false;
    }
    public float getAvgRating() {
        if (this.ratings.size()>0) {
            int sum = 0;
            for (Integer rating : this.ratings) {
                sum += rating;
            }
            double a = (float)sum / this.ratings.size();
            return (float) a;
        } else return 0;
    }
    public String toString(){
       return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    public float getPrice(){
        return price;
    }
    public int getID(){
        return id;
    }
}
