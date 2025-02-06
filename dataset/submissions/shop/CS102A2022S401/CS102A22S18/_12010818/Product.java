import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (rating >=1&&rating <= 5){
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        float sum = 0;
        float Avg;
        if (ratings.size() == 0){
            Avg = 0;
        }
        else{
            for (int i = 0; i < ratings.size(); i++){
                sum = sum + ratings.get(i);
            }
            Avg = sum/ratings.size();
        }
        return Avg;
    }

    public String toString(){
        return String.format("%s%d%s%s%s%s%.2f%s%s%.1f","Product ID ",id,", ",name,", ","RMB ",price,", ","Rating ",getAvgRating());
    }
}
