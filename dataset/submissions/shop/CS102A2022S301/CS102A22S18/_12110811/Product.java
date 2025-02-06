import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();


    public Product(String name, float price) {
        cnt++;
        this.id=cnt;
        this.name = name;
        this.price = price;
    }


    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        ratings.add(rating);
        if ((rating < 1 || rating > 5)) {
            ratings.remove(ratings.size()-1);
            return false;
        }
        return true;
    }

    public float getAvgRating() {
        float sum = 0;
        if(ratings.size()==0){
            return sum;
        }
        if(ratings.size()!=0){
            for (int i = 0; i < ratings.size(); i++) {
                sum=sum+ratings.get(i);
            }
            sum= sum/ ratings.size();
        }


        return sum;
    }

    public String toString() {
        String output = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
        return output;
    }

}
