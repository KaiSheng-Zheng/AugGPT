import java.util.ArrayList;
public class Product {
    private static int cnt =0;
    private int id = 0;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private Store store;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt += 1;
        id = cnt;
    }

    public boolean setRating(int rating){
        if(rating > 0 && rating < 6){
            this.ratings.add(rating);
            return true;
        }
        else
            return false;
    }
    public float getAvgRating(){
        int counter = 0; int total = 0;
        while(counter < ratings.size()){
            total += ratings.get(counter);
            counter++;
        }
        if(ratings.isEmpty())
            return 0f;
        else
            return (float) total/ratings.size();

    }
    public String toString(){
        return String.format("%s%d%s%.2f%s%.1f", "Product ID ", id, ", "+name+", RMB ", price, ", Rating ",
                this.getAvgRating());
    }

    public float getPrice(){
        return price;
    }

    public void setStore(Store store){
        this.store = store;
    }

    public Store getStore(){
        return store;
    }
}
