import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();

    public Product(String name,float price){
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating){
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5 ){
            ratings.add(rating);
            return true;
        }else return false;

    }

    public float getAvgRating(){
        float total =0;
        if (ratings.size() != 0 ){
        for (int i = 0; i < ratings.size(); i++) {
            total+=ratings.get(i);
        }
        return total/ratings.size();
       }else return (float) 0;
    }
@Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());

}

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
