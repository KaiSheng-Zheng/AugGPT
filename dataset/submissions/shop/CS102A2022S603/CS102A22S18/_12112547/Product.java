import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty

    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if(rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5){
            ratings.add(rating);
            return true;
        }else{
           return false;
        }
    }

    public float getAvgRating(){
        if(ratings.size() == 0){
            return 0;
        }
        float sum = 0;
        int count = 0;
        for(int num : ratings){
            sum += num;
            count++;
        }
        return (float)(sum / count) ;
    }

   public String toString(){
       BigDecimal price1 = new BigDecimal(price);
       BigDecimal rating1 = new BigDecimal(getAvgRating());
       price1 = price1.setScale(2, RoundingMode.HALF_UP);
       rating1 = rating1.setScale(1,RoundingMode.HALF_UP);
//       String resultPrice;
//       resultPrice = String.format("%.2f",price);
//       int thisPrice = Integer.parseInt(resultPrice);
//       String resultRating;
//       resultRating = String.format("%.1f",getAvgRating());
//       int thisRating =Integer.parseInt(resultRating);
      return "Product ID "+id+", "+name+", RMB "+price1+", Rating "+ rating1;
  }

    public float getPrice() {
        return this.price;
    }
}
