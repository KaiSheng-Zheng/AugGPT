import java.util.ArrayList;

public class Product {
    private static int cnt=0; 
    private int id;
    private String name;
    float price;
    private ArrayList<Integer> ratings= new ArrayList<Integer>(); 
    private int sum=0;

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        Product.cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating){
        if(rating>5||rating<1)
            return false;
        this.ratings.add(rating);
        this.sum+=rating;
        return true;
    }

    public float getAvgRating(){
        return (float)this.sum/(float)this.ratings.size();
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
    }
}
