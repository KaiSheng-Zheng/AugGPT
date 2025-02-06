
   import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private  int id; // unique for each product and the value is set to cnt.
    private  String name;
    private  float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    private int storeid=0;
    private int time=0;
    private Store store;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;

    }

    public int getStoreid() {
        return storeid;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }

    public float getPrice(){
        return this.price;
    }
    public int getId(){
        return this.id;
    }
    public boolean setRating(int rating){
        if ((rating<=5)&&(rating>=1)){
        this.ratings.add(rating);
        return true;}
        else {return false;}
    }
    public float getAvgRating(){
        float a=0;
        for (int i=0;i<this.ratings.size();i++){
            a=a+ratings.get(i);
        }if (a==0){return 0;}
        else {
        return a/this.ratings.size();}
    }
    public String toString(){
        String P=String.format("%.2f", getPrice());
        String A=String.format("%.1f",getAvgRating() );
        String id=String.valueOf(this.id);
        String description="Product ID "+id+", "+name+", "+"RMB "+P+", "+"Rating "+A;
        return description;
    }
}
