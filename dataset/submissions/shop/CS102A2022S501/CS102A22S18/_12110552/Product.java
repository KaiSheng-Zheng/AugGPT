import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        this.cnt ++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if(1 > rating || rating > 5){
            return false;
        }else
        return this.ratings.add(rating);
    }
    public float getAvgRating(){
        float sumRating = 0;
        for(int i : this.ratings){
            sumRating += i;
        }
        if(ratings.size()  == 0)
            return  0;
        return sumRating / this.ratings.size();
    }

    @Override
    public String toString() {
        
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
    }


    public float getPrice(){
        return this.price;
    }
}
