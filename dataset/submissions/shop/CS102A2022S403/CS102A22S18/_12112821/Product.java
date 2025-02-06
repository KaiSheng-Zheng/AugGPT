import java.util.ArrayList;

public class Product {
    private static int cnt ;
    private int id;  
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>() ; 
    private int location ;

    public void setLocation(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }
    public boolean setRating(int rating){
        boolean b = false;
        if(rating >= 1 && rating <= 5){
            ratings.add(rating);
            b = true;
        }
        return b;
    }
    public float getAvgRating(){
        if(ratings.isEmpty()) return 0;
        else {
            int totalNumber = ratings.size();
            float totalRatings = 0;
            for (Integer rating : ratings) totalRatings += rating;
            return totalRatings / totalNumber;
        }

    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
