import java.util.ArrayList;
public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }
        double totalRating=0;
        for (Integer rating : ratings) {
            totalRating += rating;
        }
        return (float) totalRating/ratings.size();
    }
    public float getPrice(){
        return this.price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String Price=String.format("%.2f",price);
        String Ratings=String.format("%.1f",getAvgRating());
        return "Product ID " + id + ", " + name + ", RMB " + Price + ", Rating " + Ratings;
    }
}
