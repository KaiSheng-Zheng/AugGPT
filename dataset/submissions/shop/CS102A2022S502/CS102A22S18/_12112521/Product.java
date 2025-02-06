import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        this.name = name;
        this.price=price;
        id = cnt+1;
        cnt++;
    }
    public boolean setRating(int rating){
        if(1<= rating && rating<= 5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        float a = 0;
        if(ratings.size()==0){
            return 0;
        }
        for(int i = 0; i< ratings.size(); i++){
            a += ratings.get(i);
        }
        a = a / (ratings.size());
        return a;
    }
    public String toString(){
        float a = getAvgRating();
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",id,name,price,a);
    }
    public float getPrice(){
        return price;
    }
}
