import java.util.*;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    int time=0;
    private ArrayList<Integer> ratings=new ArrayList<>();
    Store store;
    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public static int getCnt() {
        return cnt;
    }

    public float getPrice() {
        return price;
    }

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt+=1;
        this.id=cnt;

    }
    public boolean setRating(int rating){
        if(rating>5||rating<1)
return false;
        else
            ratings.add(rating);
            return true;
    }
    public float getAvgRating(){
        if(ratings.size()==0){
            return 0;
        }else{
float sum=0;
for(int i=0;i<ratings.size();i++){
    sum+=ratings.get(i);
}return sum/ratings.size();
    }}
    public String toString(){
        this.id=id;
        return("Product ID "+id+", "+name+", RMB "+String.format("%.2f",price) +", Rating "+String.format("%.1f",getAvgRating()));

    }
}