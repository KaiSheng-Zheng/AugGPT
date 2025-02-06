import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }
    public boolean setRating(int rating){
        if((rating > 5)||(rating < 1)){
            return false;
        }else {
            this.ratings.add(rating);
            return true;
        }

    }

      public float getAvgRating(){
        float sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum = sum + ratings.get(i);
        }
        if(ratings.size() == 0){
            
            float a = 0.0f;
            return a;
        }else {
            float a = sum / ratings.size();
            return a;
        }
    }
    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product ID " + id + ", " + name + ", RMB " + String.format("%.2f",price) + ", Rating " + String.format("%.1f",getAvgRating());
    }
}
