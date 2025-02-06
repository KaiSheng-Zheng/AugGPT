import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings; 

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Product(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public boolean setRating(int rating){
        if (rating < 1 | rating > 5){
            return false;
        }
        else {
            ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){
        float avg = 0;
        float all = 0;
        for (int i = 0 ;i < ratings.size();i++){
            all +=ratings.get(i);
        }
        avg = all/ratings.size();
        return avg;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ratings=" + ratings ;
    }
}