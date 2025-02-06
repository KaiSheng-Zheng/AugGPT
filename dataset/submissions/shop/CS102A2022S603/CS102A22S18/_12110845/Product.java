import java.util.ArrayList;

public class Product{
    private static int cnt = 0; 
    private int id; 
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        ++cnt;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }
    public boolean setRating(int rating){
        if(rating >= 1 && rating <=5){
            this.ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        float avgRating = 0;
        if(this.ratings.size() > 0){
            for (int i = 0; i < this.ratings.size(); i++) {
                avgRating+=ratings.get(i);
            }
            avgRating = (float)avgRating/this.ratings.size();
        }

        return avgRating;
    }
    public String toString(){

        return "Product ID "+this.id+", "+this.name
                +", RMB "+String.format("%.2f",this.price)
                +", Rating "+String.format("%.1f",getAvgRating());
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }



}
