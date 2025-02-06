import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private Store store;
    private float price;

    public int getNumber() {
        return number;
    }

    private int number;
    private ArrayList<Integer> ratings;

    public void setNumber(int number) {
        this.number = number;
    }

    public Product(String name, float price){
        this.name=name;
        this.price= price;
        this.ratings=new ArrayList<>();
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating() {
        if (ratings.size() != 0) {
            float sum = 0;
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            return sum / ratings.size();
        }else{
            return 0;
        }
    }
    public String toString(){
        String an="Product ID "+this.id+", "+this.name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
        return an;
    }
    public Store getStore(){
       return store;
    }
    public void setStore(Store store){
        this.store=store;
    }
    public int getId() {
        return id;
    }
    public static int getCnt() {
        return cnt;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
