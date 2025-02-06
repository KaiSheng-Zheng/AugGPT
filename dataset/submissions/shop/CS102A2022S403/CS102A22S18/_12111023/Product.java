import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        id++;
        cnt++;
    }

    public boolean setRating(int rating){
        ratings.add(rating);
        return rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5;
    }
    public float getAvgRating(){
        float sum = 0; float counter = 0;
        for(int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
            counter++;
        }
        BigDecimal bigDecimal = new BigDecimal(sum/(counter +1));
        float avgDelay = bigDecimal.setScale(1,BigDecimal.ROUND_HALF_UP).floatValue();
        return avgDelay;
    }
    public String toString(){
        String result = "Product ID placeforid, placeforname, RMB placeforprice, Rating placeforavgrating";
       result.replace("placeforid",String.valueOf(id)).replace("placeforname",name).replace("placeforprice",String.valueOf(price).replace("placeforavgrating",String.valueOf(getAvgRating())));
        return result;
    }
    public float getPrice(){
        return price;
    }
    public float getProductPrice(Product product){
        return price;
    }
}
