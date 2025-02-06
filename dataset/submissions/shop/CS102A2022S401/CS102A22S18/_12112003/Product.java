import java.util.ArrayList;
import java.util.Comparator;
public class Product{
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating){
        if (1 > rating||rating>5){
            return false;
        }else {
            ratings.add(rating);
            return true;
        }
    }
    public float getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public float getAvgRating(){
        float sum =0;
        for (int i=0;i<ratings.size();i++) {
            sum+=ratings.get(i);
        }
        float size= ratings.size();
        if (ratings.size()==0){
            return (float) 0;
        }else {
            return sum / size;
        }
    }

    public String toString(){
        return String.format("%s%d%s%s%s%.2f%s%.1f","Product ID ",id,", ",name,", RMB ",price,", Rating ",getAvgRating());
    }
}
class PriceComparator implements Comparator{
    public int compare(Object one,Object two){
        Product e1=(Product) one;
        Product e2=(Product) two;
        if (e1.getPrice()<e2.getPrice()) {
            return -1;
        }else return 1;
    }
}
class RatingComparator implements Comparator{
    public int compare(Object one,Object two){
        Product e1=(Product) one;
        Product e2=(Product) two;
        if (e1.getAvgRating()<e2.getAvgRating()) {
            return -1;
        }else return 1;
    }
}