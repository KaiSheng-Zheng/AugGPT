import java.util.ArrayList;

public class Product {

    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt+=1;
        this.name=name;
        this.price=price;

        this.id=cnt;
    }

    public int getId() {
        return id;
    }

    public boolean setRating(int rating){
        if (rating<=5&rating>=1){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }

    }

    public float getAvgRating(){
        if (ratings.size()==0){
            return (float) 0.0;
        }

        int sum=0;
        for (int r:ratings) {
            sum+=r;
        }

        return (float)sum/ratings.size();
    }

    public String toString(){

        String s;
        s=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());

        return s;

    }

    public float getPrice() {
            return price;
    }
}
