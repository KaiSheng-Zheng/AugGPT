import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty
    private Store store;

    public Product(String name, float price){
        cnt++;
        this.name=name;
        this.price=price;
        id=cnt;
        ratings=new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (rating>=1 && rating<=5){
            this.ratings.add(rating);
            return true;
        }
        else
            return false;
    }

    public int getId(){
        return id;
    }

    public float getPrice(){
        return price;
    }

    public float getAvgRating(){
        int sum=0;
        float avg;
        for (int i=0;i<ratings.size();i++){
            sum=sum+ratings.get(i);
        }
        if (ratings.size()>0)
        avg=(float) sum/ratings.size();
        else
            avg=0;
        return avg;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,this.getAvgRating());
    }

    public void setstore(Store store) {
        this.store=store;
    }

    public Store getStore(){
        return store;
    }

}
