import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private static int cnt=0;
    private final int id;
    private final String name;
    private final float price;
    private ArrayList<Integer> ratings;
    private int time;
    private Store place;
    public Product(String name,float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if (rating<1|rating>5){
            return false;
        }
        ratings.add(rating);
        return true;
    }
    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }
        float ak=0;
        for (int i=0;i<ratings.size();i++){
            ak+=ratings.get(i);
        }
        float bk=ak/ratings.size();
        return bk;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    public int getId(){
        return id;
    }
    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Store getPlace() {
        return place;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPlace(Store place) {
        this.place = place;
    }

    public int getTime() {
        return time;
    }
}
