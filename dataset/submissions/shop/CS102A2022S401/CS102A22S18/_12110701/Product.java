import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private final String name;
    private final float price;
    private final ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name,float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
            if(rating==1||rating==2||rating==3||rating==4||rating==5){
                ratings.add(rating);
                return true;
            }else {
                return false;
            }
    }
    public float getAvgRating(){
        float total=0;
        if(ratings.size()==0){
            return 0;
        }else {
            for (Integer rating : ratings) {
                total += rating;
            }
            return total/ratings.size();
        }
    }
    public String toString(){
        String output;
        float Avg=getAvgRating();
        String s1;
        if(price==0){
            s1= String.valueOf(0);
        }else {
            s1=String.format("%.2f",price);
        }
        String s2= String.format("%.1f",Avg);
        output="Product ID "+id+", "+name+", RMB "+s1+", Rating "+s2;
        return output;
    }
    public float getPrice() {
        return price;
    }
}