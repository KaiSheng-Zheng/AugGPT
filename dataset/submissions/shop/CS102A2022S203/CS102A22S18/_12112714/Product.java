import java.text.DecimalFormat;
import java.util.ArrayList ;

public class Product {
    private static int cnt ;
    private int id ;
    private String name ;
    private float price ;
    private ArrayList <Integer> ratings = new ArrayList <> () ;
    public Product (String name , float price) {
        id = ++cnt ;
        this.name = name ;
        this.price = price ;
    }
    public boolean setRating (int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating) ;
            return true ;
        } else return false ;
    }
    public float getAvgRating () {
        float ans = 0 ;
        for (int i = 0 ; i < ratings.size() ; ++i)
            ans += ratings.get(i) ;
        return ans / ratings.size() ;
    }
    public String toString () {
        String s = "Product ID " ; s += String.valueOf(id) ;
        s += ", " ; s += name ; s += ", RMB " ;
        DecimalFormat x1 = new DecimalFormat("0.00") ;
        String s1 = x1.format(price) ; s += s1 ;
        s += ", Rating " ; float rating = getAvgRating() ;
        DecimalFormat x2 = new DecimalFormat("0.0") ;
        String s2 = x2.format(rating) ; s += s2 ;
        return s ;
    }
}
