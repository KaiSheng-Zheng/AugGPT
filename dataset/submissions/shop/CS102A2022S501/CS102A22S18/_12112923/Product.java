import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer>ratings=new ArrayList<>();
    private int PurchaseTime;
    private Store store;

    public float getPrice(){
        return this.price;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){return this.name;}

    public void setStore(Store store){
        this.store = store;
    }
    public Store getStore(){
        return this.store;
    }

    public void setPurchaseTime(int PurchaseTime) {
        this.PurchaseTime= PurchaseTime;
    }
    public int getPurchaseTime(){return this.PurchaseTime;}

    public Product(String name,float price){
        this.name=name; this.price=price; this.id=++cnt;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum=0;
        float avg;
        int a=ratings.size();
        if(a!=0){
            for(int i=0;i<a;i++){
                sum+=ratings.get(i);
            }
            avg =sum/a;
            return avg;
        }else {
            return 0;
        }
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
    }
}

