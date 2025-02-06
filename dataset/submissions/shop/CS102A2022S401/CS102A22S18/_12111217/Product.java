import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name,float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
        }
        return rating>=1&&rating<=5;
    }
      public float getAvgRating(){
        int sum=0;
        float k;
        for (Integer rating : ratings) {
            sum = sum + rating;
        }
        if (ratings.size()==0){
            k=0;
        }
        else {
            k=(float) sum/ratings.size();
        }
        return k;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    public int getId(){
        return id;
    }
    public float getPrice(){
        return price;
    }
}
