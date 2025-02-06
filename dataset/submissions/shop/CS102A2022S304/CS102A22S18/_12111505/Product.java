import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store soldIn;
    private int time;
    public Product(String name, float price){
        this.id=++cnt;
        this.name=name;
        this.price=price;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }
        else return false;
    }

    public void setSoldIn(Store store) {
        this.soldIn=store;
    }

    public float getAvgRating() {
        int sum = 0;
        for (int i=0; i<this.ratings.size();i++) {
            sum += this.ratings.get(i);
        }
        if (sum == 0) {
            return 0;
        } else {
            float a = (float) sum / (float) this.ratings.size();
            return a;
        }
    }

    public String toString(){
        return "Product ID "+this.id+", "
                +this.name+", "
                +"RMB "+ String.format("%.2f", this.price) + ", "
                +"Rating " + String.format("%.1f", this.getAvgRating());
    }
    public float getPrice(){
        return this.price;
    }

    public Store getSoldIn() {
        return soldIn;
    }
    public void setTime(int time) {
        this.time=time;
    }

    public int getTime() {
        return this.time;
    }
}
