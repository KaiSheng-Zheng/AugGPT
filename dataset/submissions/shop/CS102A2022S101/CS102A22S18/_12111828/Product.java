import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public int getId() {
        return id;
    }
    public float getPrice() {
        return price;
    }
    public Product(String name, float price){
        this.name=name;this.price=price;cnt++;id=cnt;
    }
    public boolean setRating(int rating){
        if(rating<1||rating>5){
            return false;
        }else {
            ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){
        if(ratings.size()>0){
            int sum=0;
            for(int i=0;i<ratings.size();i++){
                sum+= ratings.get(i);
            }
            float avgRating=(float) sum/ratings.size();return avgRating;
        }
        else{return 0;}
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
