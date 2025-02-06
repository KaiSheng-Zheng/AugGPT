import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store store;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
    public ArrayList<Integer> getRatings() {
        return ratings;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }


    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
        this.ratings = new ArrayList<Integer>();
    }

    public boolean setRating(int rating){
        boolean setRating;
        if (rating<1 || rating>5){
            setRating = false;
        } else {
            ratings.add(rating);
            setRating = true;
        }
        return setRating;
    }

    public float getAvgRating(){
        float avgRating = 0;
        for (Integer i : ratings) {
            avgRating += i;
        }
        avgRating = (float) avgRating/ratings.size();
        return avgRating;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                            id, name, price, getAvgRating());
    }

}
