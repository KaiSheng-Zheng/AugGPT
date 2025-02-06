import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product (String name, float price){
        this.name = name;
        cnt ++;
        id = cnt;
        this.price = price;

    }

    public boolean setRating(int rating){
        if( rating >=1 && rating <=5 ){
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        float sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum = sum + ratings.get(i);
        }
        float avg =0.0f;
        if(ratings.size() != 0 ){
            avg = (float) ( sum / ratings.size() );
        }
        return avg;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice(){
        return price;
    }

    public int getId(){return id;}




}
