import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private final int id;
    private final String name;
    private final float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name,float price){
         cnt++;
         this.name=name;
         this.price=price;
         id=cnt;
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
        int sum = 0;
        float average;
        if(ratings.size()==0){
            return 0;
        }
        for(int rate:ratings){
            sum += rate;
        }
        average =  (float)sum/ratings.size();
        return average;
    }
    public float getPrice(){
        return price;
    }
    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
