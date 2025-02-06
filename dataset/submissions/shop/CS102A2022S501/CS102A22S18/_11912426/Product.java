
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id ;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        this.cnt = this.cnt + 1;
        this.id = this.cnt ;
        this.ratings = new ArrayList<Integer>();
    }

    public boolean setRating(int rating){
        if(rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating ==5){
            this.ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }

   public int getId(){
        return id;
   }
   public float getPrice(){
        return price;
   }




    public float getAvgRating() {
        float avg = 0;
        float sum = 0;
        for (int i = 0; i < this.ratings.size(); i++) {
            sum = sum + this.ratings.get(i);
        }
        avg = sum / this.ratings.size();
        return avg;
    }

  public String toString(){
        return "Product Id "+this.id+", "+this.name+", "+"RMB "+String.format(".2f",price)+", "+"Rating "+String.format(".1f",getAvgRating());
  }


}
