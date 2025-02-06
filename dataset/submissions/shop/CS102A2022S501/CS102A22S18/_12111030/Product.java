import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private int PurchaseTime;
    private Store store;

    public Product(String name,float price){
        ++cnt;
        this.name=name;
        this.price=price;
        this.id=cnt;
    }
    public void setStore(Store store){
        this.store=store;
    }
    public Store getStore(){
        return this.store;
    }
    public String getName(){
        return this.name;
    }
    public float getPrice(){
        return this.price;
    }
    public int getId(){
        return this.id;
    }
    public void setPurchaseTime(int PurchaseTime){
        this.PurchaseTime=PurchaseTime;
    }
    public int getPurchaseTime(){
        return this.PurchaseTime;
    }
    public boolean setRating(int rating){
        if((rating>=1)&&(rating<=5)){
            this.ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        int n = ratings.size();
        float sum=0;
        if(n>0){
            for(int i=0;i<n;i++){
                sum=sum+ratings.get(i);
            }
            double avg = sum/n;//?
            return (float)avg;
        }else{
            return 0;
        }

    }
    public String toString(){
        return"Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());//?
    }
}
