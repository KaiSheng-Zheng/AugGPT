import java.util.ArrayList;


public class Product {


    // Attributes
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    // Bonus attribute
    private Store store;


    // Constructor
    public Product(String name, float price) {

        // Alter counter
        cnt += 1;

        // Input
        this.name = name;
        this.price = price;
        this.id = cnt;
        this.ratings = new ArrayList<Integer>();

    }


    // Methods
    // setRating
    public boolean setRating(int rating) {

        // Attributes
        boolean validity;

        // Operations
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            ratings.add(rating);
            validity = true;
        } else {
            validity = false;
        }

        // Return
        return validity;

    }


    // getAvgRating
    public float getAvgRating() {

        // Attributes
        float avgRating;
        float ratingSum = 0f;

        if (ratings.size() == 0) {

            avgRating = 0;

        } else {


            for (int index = 0; index < ratings.size(); index++) {

                ratingSum += ratings.get(index);

            }

            avgRating = ratingSum / ratings.size();

        }

        //Return
        return avgRating;

    }


    // Override: toString
    @Override
    public String toString() {

        // Attributes
        String result;

        // Generating
        result = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, getAvgRating());

        // Return
        return result;

    }


    // Getters
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

    public Store getStore() {
        return store;
    }


    // Setters
    public void setStore(Store store) {
        this.store = store;
    }


}
