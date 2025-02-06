import java.util.ArrayList;

public class Product {
    // Attributes
    private static int cnt = 0;// initialized to 0, cnt += 1 when the constructor is called
    private int id;// unique for each product, the value is set to cnt
    private String name;// the name of the product
    private float price;// the price of the product
    private ArrayList<Integer> ratings;// ratings from different customers, default is empty
    private Store store;// ADDITIONAL the store to which the product belongs
    private Customer customer;// ADDITIONAL the customer to which the product belongs

    // Constructor
    public Product(String name, float price){
        cnt++;
        this.setId(cnt);
        this.setName(name);
        this.setPrice(price);
        ArrayList<Integer> ratings = new ArrayList<>();
        this.setRatings(ratings);
    }// default

    // Setter & Getter
    public void setId(int id) {
        this.id = id;
    }// Id
    public int getId() {
        return this.id;
    }// Id

    public void setName(String name){
        this.name = name;
    }// name
    public String getName(){
        return this.name;
    }// name

    public void setPrice(float price) {
        this.price = price;
    }// price
    public float getPrice() {
        return this.price;
    }// price

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }// ratings
    public ArrayList<Integer> getRatings() {
        return this.ratings;
    }// ratings

    public void setStore(Store store) {
        this.store = store;
    }// store
    public Store getStore() {
        return this.store;
    }// store

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }// customer
    public Customer getCustomer() {
        return this.customer;
    }// customer

    /**
     * the range of rating is [1,5], if rating is out of this range, don't add it into ratings and return false
     * @return whether the operation succeeds
     */
    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            this.getRatings().add(rating);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sum all the ratings it has received so far and get the average.
     * @return the average rating of this product
     */
    public float getAvgRating(){
        float AvgRating = 0f;
        if (this.getRatings().size() != 0){
            for (int bit : this.getRatings()){
                AvgRating += bit;// sum all ratings
            }
            return AvgRating / this.getRatings().size();// get average
        } else {
            return 0f;
        }
    }// getAverageRatings

    /**
     * @return a formatted string describing this product
     */
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                this.getId(), this.getName(), this.getPrice(), this.getAvgRating());
    }// toString
}