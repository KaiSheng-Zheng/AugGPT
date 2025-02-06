import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id ;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public  int t = 0;
    public static int cont =0;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        if(rating==1||rating==2||rating==3||rating==4||rating
        ==5) {
            ratings.add(rating);
            return true;
        } else
            return false;
    }
    public int getId() {
        return id;
    }
    public float getAvgRating(){
        float sum = 0;
        float b;
        if(ratings.size()!=0) {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            b = (float) (sum / (ratings.size()));
            return b ;
        }else
            return 0;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
