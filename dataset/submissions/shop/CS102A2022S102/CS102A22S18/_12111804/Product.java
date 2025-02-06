import java.util.ArrayList;
public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private int StoreId;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt += 1;
        id = cnt;
    }
    public void setStoreId(){
        this.StoreId = StoreId;
    }
    public int getStoreId(){
        return StoreId;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5)
            return false;
        else
            ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        float avg = 0.0F;
        for(int i = 0;i<ratings.size();i++){
            avg = avg+(float)ratings.get(i)/ratings.size();
        }
        return avg;
    }

    public String toString() {
        String str1 = String.valueOf(id);
        String str2 = String.valueOf(price);
        String str3 = String.valueOf(getAvgRating());
        return "Product ID " + str1 + ", " + name + ", RMB " + str2 + ", Rating " + str3;
    }
}
