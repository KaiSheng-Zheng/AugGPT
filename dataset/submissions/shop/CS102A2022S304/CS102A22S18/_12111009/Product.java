import java.util.ArrayList;
import java.util.Comparator;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> rating=new ArrayList<>();
    public Product(String name,float price){
        this.name=name;
        this.price=price;
        cnt+=1;
        this.id=cnt;
    }public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            this.rating.add(rating);
            return true;
        }else return false;
    }
    public float getAvgRating(){
        int sum=0;
        for (Integer integer : rating) {
            sum += integer;
        }
        return (float) sum/rating.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
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
    public static Comparator<Product> byprice = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            Float p1 = o1.getPrice();
            Float p2 = o2.getPrice();
            return p1.compareTo(p2);
        }
    };
    public static Comparator<Product> byRate = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            Float r1 = o1.getAvgRating();
            Float r2 = o2.getAvgRating();
            return r1.compareTo(r2);
        }
    };
}