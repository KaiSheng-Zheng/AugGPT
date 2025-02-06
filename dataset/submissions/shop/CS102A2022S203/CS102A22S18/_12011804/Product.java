import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    public Store store;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id=cnt;
        this.ratings = new ArrayList<>();
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating<=5 && rating >= 1) {
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        if (ratings.isEmpty()){
            return 0.0f;
        }
        int sum=0;
        for (int i = 0; i < ratings.size(); i++) {
            sum = ratings.get(i)+sum;
        }
        return (float) sum/ratings.size();
    }
    public String toString(){
        String pri = String.format("%.2f",price);
        String ave = String.format("%.1f",getAvgRating());
        return ("Product ID "+id+", "+name+", RMB "+pri+", Rating "+ave);
    }

}
