import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private float Sum=0;
    Store buyFrom;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }



    public boolean setRating(int rating){
        if(rating<=5&&rating>=1) {
            Sum += rating;
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        if(ratings.size()==0){
            return 0;
        }
        return Sum/ratings.size();
    }
    @Override
    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
