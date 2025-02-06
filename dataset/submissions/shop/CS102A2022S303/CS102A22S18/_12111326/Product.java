import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id ;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Store store;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(String name, float price){
        this.id = ++cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
        if (1 <= rating && rating <= 5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        float average;
        float all = 0;
        if (ratings.size() == 0){
            return 0;
        }else {
            for (int i = 0; i < ratings.size(); i++) {
                all = all + ratings.get(i);
            }
            average = all / ratings.size();
            return average;
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

}


