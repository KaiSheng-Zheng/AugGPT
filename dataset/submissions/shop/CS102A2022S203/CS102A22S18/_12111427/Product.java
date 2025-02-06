import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store sellsFrom;
    private int sellsTime;

    public int getSellsTime() {
        return sellsTime;
    }

    public void setSellsTime(int sellsTime) {
        this.sellsTime = sellsTime;
    }

    public Store getSellsFrom() {
        return sellsFrom;
    }

    public void setSellsFrom(Store sellsFrom) {
        this.sellsFrom = sellsFrom;
    }

    public float getPrice() {
        return price;
    }

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        if(ratings.isEmpty()){
            return 0;
        }
        float sum = 0;
        for(int i=0;i<ratings.size();i++){
            sum += ratings.get(i);
        }
        float result = (float) sum/ratings.size();
        return result;
    }

    public String toString(){
        String str = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,(float)Math.round(price*100)/100,getAvgRating());
        return str;
    }
}
