import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    private Store comefrom;

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
             ratings.add(new Integer(rating));
             return true;
        }else{
            return false;
        }
    }

    public float getAvgRating(){
        int sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        if (sum == 0){
            return 0;
        }
        return ((float) sum) / ratings.size();
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price = price;
    }

    public Store getComefrom() {
        return comefrom;
    }
    public void setComefrom(Store comefrom) {
        this.comefrom = comefrom;
    }
}
