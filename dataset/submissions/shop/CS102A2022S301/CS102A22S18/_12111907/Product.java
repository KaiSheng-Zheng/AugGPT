import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

public class Product  {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer>ratings;
    public Product(String name,float price){
        cnt++;
        this.name=name;
        this.price=price;
        this.id=cnt;
        ratings = new ArrayList<Integer>();
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum=0;
        if (ratings.size()==0){
            return 0;
        }
        else {
            for (int i=0;i< ratings.size();i++){
                sum+=ratings.get(i);
            }
            float result=sum/ ratings.size();
            return result;
        }
    }
    public String toString(){
        String answer=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price, getAvgRating());
        return answer;
    }
    public float getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
}
class RatingComparator implements Comparator{
    public int compare(Object o1,Object o2){
        Product p1=(Product) o1;
        Product p2=(Product) o2;
        if (p1.getAvgRating()< p2.getAvgRating()){
            return -1;
        }
        else {
            return 1;
        }
    }
}
class PriceComparator implements Comparator{
    public int compare(Object o1,Object o2){
        Product p1=(Product) o1;
        Product p2=(Product) o2;
        if(p1.getPrice()<p2.getPrice()){
            return -1;
        }
        else {
            return 1;
        }

    }
}


