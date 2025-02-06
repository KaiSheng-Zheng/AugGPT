import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price){
        cnt ++;
        id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){ratings.add(rating);
            return true;}
        else return false;
    }
    public float getAvgRating(){
        float sum = 0;int i ; float AvgRating=0;
        if(ratings.size()==0)return AvgRating;
        else{for(i=0;i<ratings.size();i++){
            sum= sum+ ratings.get(i);
        }AvgRating= sum/ratings.size();
        }
        return AvgRating;
    }
    public String toString(){
        String Ratings = String.format("%.1f",this.getAvgRating());
        String Price = String.format("%.2f",this.getPrice());
        return  "Product ID "+id+", "+name+", RMB "+Price+", Rating "+Ratings;
    }
    public float getPrice(){
        return price;
    }
}
