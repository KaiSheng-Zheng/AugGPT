import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name,float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }

    public boolean setRating(int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }

    public float getAvgRating(){
        float d= 0.0F,sum=0.0F;
        if (ratings.size() != 0) {
            for (int i = 0; i < ratings.size(); i++) {
                sum+=ratings.get(i);
            }
            d=sum/ratings.size();}
        return d;
        }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
    }
}
