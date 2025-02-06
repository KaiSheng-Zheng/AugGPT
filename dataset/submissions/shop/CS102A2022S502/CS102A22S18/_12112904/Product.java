import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();// ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }

    public boolean setRating(int rating){
        if(rating>0&&rating<6){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        if(ratings.size()!=0){
        float a=0;
        for (Integer rating : ratings) {
            a = a + rating;
        }
        return a/ratings.size();
        }else {
            return 0;
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
    }

    public int getId(){return this.id;}

    public float getPrice(){return this.price;}


}