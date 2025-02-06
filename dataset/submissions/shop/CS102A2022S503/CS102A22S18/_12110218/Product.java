import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
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
        return false;
    }
    public float getAvgRating(){
        float total=0;
        for (int i = 0; i < ratings.size(); i++) {
            total+= ratings.get(i);
        }
        if (total==0){
            return 0;
        }
        return total/= ratings.size();
    }

    public float getPrice() {
        return price;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
    }
}
