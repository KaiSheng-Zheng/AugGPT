import java.util.ArrayList;

public class Product {

    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty
    Store store;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (rating>=1 && rating <=5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }

    public float getAvgRating(){
        float ave;float sum = 0;
        for (int d:ratings) {
            sum+=d;
        }
        if (ratings.size() == 0){
            ave = 0;
        }else{
            ave = sum / ratings.size();
        }
        return ave;
    }

    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Product product1 = new Product("brush", 100);
        product1.setRating(1);product1.setRating(5);
        System.out.println(product1);
    }
}
