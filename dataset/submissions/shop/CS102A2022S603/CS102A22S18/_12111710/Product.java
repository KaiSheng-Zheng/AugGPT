import java.util.ArrayList;
public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
     public Product(String name, float price){
     this.price=price;
     this.name=name;
     cnt++;
     this.id=cnt;
     }
    public boolean setRating(int rating){
    if(rating<=5&rating>=1) {
        ratings.add(rating);
        return true;
    }else{
        return false;
    }
    }
    public float getPrice(){
         return this.price;
    }
    public  float getAvgRating(){
    float sum=0;
    float avg;
    for(int i=0;i<ratings.size();i++){
        sum+=ratings.get(i);
    }
    avg=sum/ratings.size();
    return avg;
    }
    public String toString(){
    String ID="Product ID "+id+", ";
    String Name=name+", ";
    String Price="RMB "+String.format("%.2f,",price);
    String Rating=" Rating "+String.format("%.1f",getAvgRating());
    return ID+Name+Price+Rating;
    }
    }

