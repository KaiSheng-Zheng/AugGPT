import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;

    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }

    public float getAvgRating(){
        if(this.ratings.size()==0){
            return 0;
        }
        else {
            int sum = 0;
            for (int i = 0; i < this.ratings.size(); i++) {
                sum += this.ratings.get(i);
            }
            float avg = (float) sum / this.ratings.size();
            return avg;
        }
    }

    public String toString(){
        String str = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
        return str;
    }

    public float getPrice() {
        return price;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
}

