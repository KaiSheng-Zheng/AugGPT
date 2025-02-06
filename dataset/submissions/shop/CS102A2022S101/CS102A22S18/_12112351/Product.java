import java.util.ArrayList;

public class Product {
    private static int cnt = 0 ;
    private int id ; ;
    private String name ;
    private float price ;
    private ArrayList<Integer> ratings = new ArrayList<>() ; //wrong

    public Product(String name, float price) {
        this.name = name ;
        this.price = price ;
        Product.cnt++ ;
        this.id = Product.cnt ;
    }

    public boolean setRating(int rating) { //rating from customer?
        if (rating >= 1 && rating <= 5) { //
            ratings.add(rating) ;
            return true ;
        } else {
            return false ;
        }
    }

    public float getAvgRating() {  //wrong
        if (ratings.size() == 0){
            return 0 ;
        } else {
            float sumRating = 0 ;
            for (int i=0 ; i < ratings.size() ; i++) {
                sumRating += ratings.get(i);
            }
            return sumRating/ratings.size() ;
        }
    }

    public float getPrice() {
        return this.price ;
    }



    public String toString() { //wrong
            return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, this.getAvgRating());
    }



}
