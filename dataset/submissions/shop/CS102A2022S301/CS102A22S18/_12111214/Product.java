import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public float getPrice() {
        return price;
    }

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        this.id=cnt+1;
        cnt++;
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else{return false;}
    }
    public float getAvgRating(){
        if (ratings.size()!=0){
            float avgRating, sumRating = 0;
            for (int i = 0; i < ratings.size(); i++) {
                sumRating += ratings.get(i);
            }
            avgRating = sumRating / (float) ratings.size();
            return avgRating;
        }
        else{return 0;}
    }
    public String toString(){
        String introduce=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,0.01f*(float)Math.round(price*100),0.1f*(float)Math.round(this.getAvgRating()*10));
        return introduce;
    }
}
