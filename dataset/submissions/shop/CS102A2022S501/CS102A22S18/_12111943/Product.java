import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Store store;
    public Customer customer;
    public int buyOrder;


    public int getId(){
        return this.id;
    }

    public float getPrice(){
        return this.price;
    }

    public Product(String name,float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating>0 && rating<6){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }

    public float getAvgRating(){
        int sum = 0;
        if(ratings.size() != 0){
            for(int i=0; i<ratings.size(); i++){
                sum += ratings.get(i);
            }
            float f = (float) sum/ratings.size();
            return f;
        }
        return 0.0F;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        String s1 = String.format("%.2f", price);
        String s2 = String.format("%.1f", getAvgRating());
        s.append("Product ID ").append(this.id).append(", ").append(this.name).append(", RMB ").append(s1).append(", Rating ").append(s2);
        return s.toString();
    }
}
