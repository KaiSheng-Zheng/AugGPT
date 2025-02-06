import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price=0;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    private int storeId;
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public void setStoreId(int StoreId){
        this.storeId=StoreId;
    }
    public int getStoreId(){
        return storeId;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }
        else return  false;
    }
    public float getPrice(){
        return price;
    }
    public float getAvgRating(){
        float Average=0;
        for(int i=0;i<ratings.size();i++){
            Average=Average+(float)ratings.get(i)/ratings.size();
        }
        return Average;
    }
    public int getId(){
        return id;
    }


    public String toString(){
        return "Product ID "+String.valueOf(id)+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }
//Product ID 12345, Laptop, RMB 10000.00, Rating 4.5
}
