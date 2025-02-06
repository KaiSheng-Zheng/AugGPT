import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        this.cnt++;
        this.id=cnt;
    }
    public boolean setRating(int rating) {
        if(rating==1||rating==2||rating==3||rating==4||rating==5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getPrice(Product product){
        return product.price;
    }
    public float getAvgRating(){
        float sum=0;
        if(ratings.size() == 0) return 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum=sum+ratings.get(i);
        }
        float avg=sum/(float)ratings.size();
        return avg;
    }
    public String toString(){
        String string=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return string;
    }
}
