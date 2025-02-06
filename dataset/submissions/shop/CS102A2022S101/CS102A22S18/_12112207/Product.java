
import java.util.ArrayList;

public class Product {

    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){this.name=name;this.price=price;cnt++;id=cnt;}


    public boolean setRating(int rating){
        if (rating!=1&&rating!=2&&rating!=3&&rating!=4&&rating!=5){
            return false;
        }else ratings.add(rating);return true;
    }


    float total=0;float avg=0;
    public float getAvgRating(){
        for (int i=0;i<ratings.size();i++){
            int n=ratings.get(i);
            total+=n;
        }avg=total/ratings.size();
        return avg;
    }
    public float getRating(){return avg;}

    public float getPrice(){return price;}
    public void setPrice(float price){this.price=price;}

    public String toString(){
        String i="Product ID "+String.valueOf(id)+", "+name+", "+"RMB "+String.valueOf(String.format(".2f",price)) +", "+"Rating "+String.valueOf(String.format("%.1f",getRating()));
        return i;
    }




}