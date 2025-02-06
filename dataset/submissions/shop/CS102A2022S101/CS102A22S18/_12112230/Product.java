import java.util.ArrayList;
import java.util.Comparator;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>(); // ratings from different customers; defaultis empty.
    protected Store fromstore;
    public Product(String name, float price) {
        id = ++cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {

        if (rating < 6 && rating > 0) {
            ratings.add(rating);
            return true;
        }
        return false;
    }

     public float getAvgRating() {

         Integer sum = 0;
         if(!ratings.isEmpty()) {
             for (Integer mark : ratings) {
                 sum += mark;
             }
             return sum.floatValue() / ratings.size();
         }
         return sum;
    }

    @Override
    public String toString() {

        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());

    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public static Comparator<Product> ProPrice = new Comparator<Product>() {

        public int compare(Product s1, Product s2) {
            float rollno1 = s1.getPrice()*100;
            float rollno2 = s2.getPrice()*100;

            /* For ascending order */
            return (int) (rollno1 - rollno2);

            // descending order
            // return StudentName2.compareTo(StudentName1);
        }
    };

    /* Comparator for sorting the list by roll no */
    public static Comparator<Product> ProRatings = new Comparator<Product>() {

        public int compare(Product s1, Product s2) {

            float rollno1 = s1.getAvgRating()*10;
            float rollno2 = s2.getAvgRating()*10;

            /* For ascending order */
            return ((int)rollno1 - (int)rollno2);

            /* For descending order */
            // rollno2-rollno1;
        }
    };


}
