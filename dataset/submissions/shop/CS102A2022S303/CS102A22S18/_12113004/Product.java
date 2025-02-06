import java.util.ArrayList;

public class Product {

    private static int cnt = 0;
    // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;
    // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    // ratings from different customers; defaults empty.

    /**
     * constructor and setter and getter
     * @param name
     * @param price
     */
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
        ratings = new ArrayList<>();
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    /**
     * Set rating to the product. The rating would be added to this product's rating list ratings.
     * @param rating the element should be added to this product's list ratings
     * @return If rating is not in range [1,5], do not add it into rating and return false.
     */
    public boolean setRating(int rating){
        if(1 <= rating && rating <= 5){
            getRatings().add(rating);
            return true;
        }
        else
            return false;
    }

    /**
     * the average of rating
     * @return the average rating of this product
     *         which is computed as the average of all the ratings it has received so far.
     *
     */
    public float getAvgRating(){
        float output = 0;
        if (getRatings().size()!=0) {
            for (int i = 0; i < getRatings().size(); i++) {
                output += getRatings().get(i);
            }
            output = output / getRatings().size();
        }
        return output;
    }

    /**
     * Return a string description of this product
     * @return Product ID id, name, RMB price, Rating average-rating
     */
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                             getId(),getName(),getPrice(),getAvgRating());
    }



}
