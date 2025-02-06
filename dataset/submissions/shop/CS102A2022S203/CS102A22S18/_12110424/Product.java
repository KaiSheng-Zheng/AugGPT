import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id=0; // unique for each product and the value is set to cnt.
    private String name="";
    private float price=0;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    private Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating(){
        float all=0;
        for (int  n :ratings){
            all+=n;
        }
        if (all==0) return 0;
        return all/ratings.size();
    }






    public String toString(){
        return "Product ID "+String.valueOf(id)+", "+name+", RMB "+String.format("%.2f",getPrice())+", Rating "+String.format("%.1f",getAvgRating());
    }


}
