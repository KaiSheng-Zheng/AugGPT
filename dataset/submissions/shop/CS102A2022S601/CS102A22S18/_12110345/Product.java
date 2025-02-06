import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name,float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }
    public float getAvgRating(){
        float sum=0;
        for(int i=0;i<ratings.size();i++){
            sum+=ratings.get(i);
        }return sum==0?0:sum/ratings.size();
    }
    public String toString(){
        String str = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return str;
    }

    public int getID() {
        return id;
    }

    public float getPrice() {
        return price;
    }

}
