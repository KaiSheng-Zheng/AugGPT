import java.math.BigDecimal;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private float avg;
    private int purchaseTime;

    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        BigDecimal a = new BigDecimal(price);
        this.price = a.setScale(2,BigDecimal.ROUND_HALF_DOWN).floatValue();
    }

    public boolean setRating(int rating){
        boolean range = true;
        if(rating > 5 || rating < 1){
            range = false;
        } else {
            ratings.add(rating);
        }
        return range;
    }

    public float getAvgRating(){
        float sum = 0;
        float num = 0;
        float avg,averg;
        if(ratings.size() == 0) {
            avg = 0.0F;
        } else {
            for(int i = 0; i < ratings.size(); i++){
                sum = sum +ratings.get(i);
                num++;
            }
            avg = sum/num;
        }
        this.avg = avg;
        BigDecimal b = new BigDecimal(avg);
        averg = b.setScale(1,BigDecimal.ROUND_HALF_DOWN).floatValue();
        return averg;
    }

    public float getTrueAvg(){
        return this.avg;
    }

    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.getId(),this.getName(),this.getPrice(),this.getAvgRating());
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public boolean equal(Product obj){
        boolean equal = false;
        if(this.name.equals(obj.name) && this.price == obj.price){
            equal = true;
        }
        return (equal);
    }

    public float getPrice(){
        return price;
    }

    public void upDatePurchaseTime(){
        purchaseTime++;
    }

    public int getPurchaseTime(){
        return purchaseTime;
    }

}
