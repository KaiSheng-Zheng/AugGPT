import java.util.ArrayList;

public class Product {
    private Store store;

    private static int cnt = 0;

    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    private Product product;

    public Product(Product product) {
        this.product = product;
    }

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        if (name == null) {
            this.name = "";
        } else {
            this.name = name;
        }
        this.price = price;
    }


    public boolean setRating(int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0;
        }
        else {
            int sum = 0;
            for (Integer rating : ratings) {
                sum += rating;
            }

            return (float) sum / ratings.size() ;
        }
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Store getStore() {
        return store;
    }
    
    public void setStore(Store store) {
        this.store = store;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public static void main(String[] args) {
        Product product = new Product("a",0);
        product.setRating(1);
        System.out.println(product.ratings);
        System.out.println(product.getAvgRating());

    }


}
