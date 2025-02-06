import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id = cnt ;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }


    public float getAvgRating(){
        if (ratings.size()==0){
            return (float) 0;
        }else {
            float sum=0;
            for (Integer rating : ratings) {
                sum += rating;
            }
            return sum/ratings.size();
        }
    }


    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
    }


    public Integer getID() {
        return id;
    }
}