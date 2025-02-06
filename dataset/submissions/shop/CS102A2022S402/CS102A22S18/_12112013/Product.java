import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();
    private Store location;
    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if (rating>=1 &&rating<=5){
            this.ratings.add(rating);
            return true;
        }else return false;
    }
    public float getAvgRating(){
        int sum=0;
        float avg;
        if (this.ratings.size()>=1){
            for (int i=0;i<ratings.size();i++){
                sum+=ratings.get(i);
            }
            avg=(float)sum/(float)ratings.size();
        }else avg=0.00f;
        return avg;
    }
    public String toString(){
        String sta=String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",getId(),this.name,getPrice(),getAvgRating());
        return sta;
    }
    public float getPrice(){
        return this.price;
    }
    public void setPrice(Float price){
        this.price=price;
    }
    public int getId(){
        return this.id;
    }
    public void setLocation(Store store){
        this.location=store;
    }
    public Store getLocation(){
        return this.location;
    }
}
