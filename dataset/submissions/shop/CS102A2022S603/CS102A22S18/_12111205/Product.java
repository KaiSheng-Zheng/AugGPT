import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private Store ProductStoreName;
    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
        if(rating>=1 && rating<=5){
            ratings.add(rating);
            return true;
        }
        else
            return false;
    }

    public float getAvgRating() {
        float b=0;
        if (ratings.size() > 0) {
            int total = 0;
            for (Integer rating : ratings) {
                total += rating;
            }
            b=(float) total / ratings.size();
        }
        return b;
    }

    @Override
    public String toString() {
        return "Product ID " + this.id + ", " + this.name + ", RMB " + String.format("%.2f", price) + ", Rating " + String.format("%.1f",this.getAvgRating()) ;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void SetProductStoreName(Store store){
       ProductStoreName= store;
    }

    public Store getProductStoreName(){
        return ProductStoreName;
    }
}
