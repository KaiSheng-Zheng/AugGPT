import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings=new ArrayList<>();
    }

    public float getPrice() {
        return this.price;
    }

    public boolean setRating(int rating){
        if(rating<1 || rating>5){
            return false;
        }else{
            this.ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){
        float s = 0;
        if(this.ratings.size()==0){
            return 0;
        }else{
            for(int i=0;i<this.ratings.size();i++){
                s+=this.ratings.get(i);
            }
            return s/this.ratings.size();
        }
    }

    @Override
    public String toString(){
        return "Product ID "+this.id+", "+this.name+", RMB "+String.format("%.2f",this.price)+", Rating "+String.format("%.1f",this.getAvgRating());
    }
}
