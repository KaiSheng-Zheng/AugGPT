import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public float getPrice(){
        return price;
    }
    public Product(String name,float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
        int sum=0;
        for(int i=0;i<ratings.size();i++){
            sum+=ratings.get(i);
        }
        return (float)(sum)/(float)(ratings.size());
    }
    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }
}
