import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price) {
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }
    public float getPrice(float price){
        return price;
    }

    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }

    public float getAvgRating(){ //rating=0,return 0;
        float sum=0;
        if(ratings.size()!=0){
            for (int integer : ratings) {
                sum += integer;
            }
            return sum/ratings.size();
        }
        else{
            return 0;
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice() {
        return this.price;
    }

    public int getID(){
        return this.id;
    }
}