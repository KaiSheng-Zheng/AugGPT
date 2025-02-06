import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
   
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public ArrayList<Integer> getRatings() {
        return ratings;
    }
    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    
    public Product(String name,float price){
       this.name=name;
       this.price=price;
       cnt++;
       id=cnt;
    }
    public boolean setRating(int rating) {
        
            if (rating > 0 & rating < 6) {
                ratings.add(rating);
            } else {
                return false;
          
        }return true;
    }

    public float getAvgRating(){
        float sum=0;
        for(int i=0;i<ratings.size();i++){
            sum+=ratings.get(i);
        }float su=sum/ratings.size();
        return su;
    }
    public String toString(){
        DecimalFormat one =new DecimalFormat("0.0");
        DecimalFormat two =new DecimalFormat("0.00");
        return "Product ID"+id+","+name+","+"RMB"+two.format(price)+","+"Rating"+one.format(this.getAvgRating());
    }
}