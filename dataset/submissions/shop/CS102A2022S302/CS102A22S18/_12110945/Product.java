import java.util.ArrayList;

public class Product {
    private static int cnt =0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id ;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
                  //id =1;
                  cnt++;
                  this.id = cnt;
                this.price =price;
                this.name = name;
    }
    public boolean setRating(int rating) {
        //if (rating > 5 && rating < 1){
           // return false;
       // }
        if (rating <= 5 && rating >= 1) {
            ratings.add(rating);
            return true;
        }else {
            return false;//
        }
    }
    public float getAvgRating(){
        float sum =0;
        if (ratings.size()==0){
            return sum;//?
        }
        for (Integer rating : ratings) {
            sum = sum + rating;
        }
        return sum / ratings.size();//?
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    public float getPrice(){
        return price;
    }
}














