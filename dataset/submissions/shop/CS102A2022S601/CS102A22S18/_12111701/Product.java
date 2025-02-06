import java.math.BigDecimal;
import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private int a;
    private Store m;

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(1 <= rating && rating <= 5){
            this.ratings.add(rating);
        return true;
        }else{ return false;  }
    }
    public float getAvgRating(){
        if(this.ratings.size() == 0){
            return  0;
        }else{
            int totalrate = 0;
            float avr = 0;
            for(int i = 0; i < ratings.size(); i++){
                totalrate += ratings.get(i);
            }
            return (float)((double)totalrate / ratings.size());
        }

    }
    public String toString(){
        BigDecimal a = new BigDecimal(this.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal b = new BigDecimal(this.getAvgRating()).setScale(1, BigDecimal.ROUND_HALF_UP);
        return "Product ID "+id+", "+name+", "+"RMB "+a+", "+"Rating "+b;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public Store getS(){
        return m;
    }
}

