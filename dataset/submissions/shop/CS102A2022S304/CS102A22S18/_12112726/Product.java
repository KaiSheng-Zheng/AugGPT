import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
    }

    @Override
    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",getPrice())+", Rating "+String.format("%.1f",getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if (1<=rating&&rating<=5) {
            ratings.add(rating);
            return true;
        }
        else
            return false;
    }

    public float getAvgRating(){
        float total=0;
        if (ratings.isEmpty())
            return 0;
        else {
            for (Integer rating : ratings) {
                total += rating;
            }
            return total / ratings.size();
        }
    }
}