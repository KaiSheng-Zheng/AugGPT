import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public float getPrice() {
        return price;
    }

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }

    public boolean setRating(int rating){
        if (rating>0&&rating<6){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        double averageValue = 0;
        double sum = 0;

        if(ratings.size() > 0){
            for ( int i=0; i < ratings.size() ; i++) {
                sum += ratings.get(i);
            }
            averageValue = (sum / (double)ratings.size());
        }
        return (float) averageValue;
    }
    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }

}
