
import java.util.ArrayList;
import java.math.BigDecimal;

public class Product {
    private static int cnt;
    private  int id;
    private  String name;
    private  float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private Store s;
    private int a;

    public int getId(){
        return this.id;
    }

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating){
     if(rating>=1&rating<=5){
     ratings.add(rating);
     return true;
     }else {
     return false;
}
    }
    public float getAvgRating() {
        int n = this.ratings.size();
        if(n==0){
            return 0;
        }else{
        int sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        return (float) ((double)sum/n);
    }}
    public String toString(){
        BigDecimal a = new BigDecimal(this.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal b = new BigDecimal(this.getAvgRating()).setScale(1, BigDecimal.ROUND_HALF_UP);
        return "Product ID "+id+", "+name+", "+"RMB "+a+", "+"Rating "+b;
    }
    public float getPrice(){
        return this.price;
    }
    public Store getS(){
        return s;
    }
    public void sets(Store a){
        this.s = a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }



}
