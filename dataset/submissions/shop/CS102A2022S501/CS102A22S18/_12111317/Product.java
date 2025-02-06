import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt += 1;
        this.id = cnt;
    }

    public int getId() {
        return id;
    }

    public boolean setRating(int rating){
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating ==5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        if(ratings.size()==0){
            return 0;
        }
        else{
            int count = this.ratings.size();
            int Sum = 0;
            for (int i = 0; i < ratings.size(); i++) {
                Sum += ratings.get(i);
            }
            return new BigDecimal((float)Sum/count).setScale(1, RoundingMode.HALF_UP).floatValue();
        }
    }

    public float getAccurateRating(){
        int count = this.ratings.size();
        int Sum = 0;
        for (Integer rating : ratings) {
            Sum += rating;
        }
        return new BigDecimal((float)Sum/count).setScale(5, BigDecimal.ROUND_HALF_UP).floatValue();
    }
    public float getPrice(){
        return price;
    }

    public String toString(){
        String s=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
        return s;
    }
}
