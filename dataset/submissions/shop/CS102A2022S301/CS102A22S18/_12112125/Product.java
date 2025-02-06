import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id=cnt;
        this.ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        if (ratings.isEmpty()){
            return 0;
        }
        else {
            float total = 0;
            for (int i : this.ratings) {
                total += i;
            }
            return total / this.ratings.size();
        }
    }
    @Override
    public String toString(){
        String price=String.format("%.2f",this.price);
        String rating=String.format("%.1f",this.getAvgRating());
        return ("Product ID "+this.id+", "+this.name+", RMB "+price+", Rating "+rating);
    }
}
