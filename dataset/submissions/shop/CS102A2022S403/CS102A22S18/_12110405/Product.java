import java.util.ArrayList;


public class Product {

    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating > 0 && rating < 6) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Buy.Product ID" + id + ", " + name + ", RMB " + String.format("%.2f", price) + ", Rating " + String.format("%.1f", getAvgRating());
    }


    public float getAvgRating() {
        float addAns = 0,avg=0;
        if(this.ratings.size()==0){
        }else {
            for (int i =0; i<this.ratings.size();i++){
           addAns+=this.ratings.get(i);
            }
            avg =addAns/this.ratings.size();
        }
        return avg;
    }


    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public static int getCnt() {
       return cnt;
   }

  public int getId() {
        return id;
   }

    public String getName() {
      return name;
    }

    public float getPrice() {
        return price;
    }
    public ArrayList<Integer> getRatings() {
        return ratings;
    }

}