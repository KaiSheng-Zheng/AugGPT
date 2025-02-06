import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings =new ArrayList<>(); // ratings from different customers; default is empty.

    //The id of the first product is 1. The given price is always valid.
    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = new String(name);
        this.price = price;
    }

    /*
    Set rating to the product. The rating would be added to this product's rating list ratings.

    A rating should be within the range [1,5]; in other words, there are only 5 possible values for rating.
    If rating is not in this range, do not add it into rating and return false
    */
    public boolean setRating(int rating) {
        Boolean b = (rating >= 1 && rating <= 5);
        if (!b) {
            return false;
        } else {
            this.ratings.add(rating);
            return true;
        }
    }

    /*
    Return the average rating of this product,
    which is computed as the average of all the ratings it has received so far.
    */
    public float getAvgRating() {
        if (this.ratings.size()==0){
            return 0f;
        }
        else {float sum = 0f;
        for (Integer rates : this.ratings) {
            sum = rates + sum;
        }
        float average = sum / (this.ratings.size());
        return average;}
    }

    /*
    Return a string description of this product, in the format of Product ID id, name, RMB price, Rating
    average-rating, e.g., Product ID 12345, Laptop, RMB 10000.00, Rating 4.5.

    Round price to 2 decimal places and rating to 1 decimal place.
    */
    public String toString() {
        BigDecimal price = new BigDecimal(this.price);
        BigDecimal rating = new BigDecimal(this.getAvgRating());
        Float price1 = price.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
        Float rating1 = rating.setScale(1,BigDecimal.ROUND_HALF_UP).floatValue();

        DecimalFormat decimalFormat = new DecimalFormat("0.00#");
        String priceStr = decimalFormat.format(price1);
        DecimalFormat decimalFormat1 = new DecimalFormat("0.0#");
        String ratingStr = decimalFormat1.format(rating1);


        String description = new String("Product ID " + this.id + ", "
                + this.name + ", "
                + "RMB " + priceStr + ", "
                + "Rating " + ratingStr);
        return description;
    }


    public Float getPrice() {
        return this.price;
    }

















    public static Comparator<Product> priceComparator = new Comparator<Product>() {

 
        public int compare(Product p1, Product p2) {
            Float price1 = p1.getPrice();
            Float price2 = p2.getPrice();


                return price1.compareTo(price2);

   
        }
    };


    public static Comparator<Product> rateComparator = new  Comparator<Product>() {

        public int compare(Product p1, Product p2) {

            Float rate1 = p1.getAvgRating();
            Float rate2 = p2.getAvgRating();

 
            return rate1.compareTo(rate2);



        }
    };

}





