import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        } else return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.removeProduct(product);
            shoppingCart.add(product);
            store.transact(product,0);
            updateWallet(-1*product.getPrice());
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Rating) {
            shoppingCart.sort(new Rating());
            for (Product rateProduct : shoppingCart) {
                System.out.println(rateProduct);
            }
        } else if (sortMethod == SortBy.Price) {
            shoppingCart.sort(new Price());
            for (Product priceProduct : shoppingCart) {
                System.out.println(priceProduct);
            }
        }
    }

    static class Rating implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            if (p1.getAvgRating() < p2.getAvgRating()) {
                return -1;
            }
            if (p1.getAvgRating() == p2.getAvgRating()) {
                return 0;
            } else return 1;
        }
    }

    static class Price implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            if (p1.getPrice() < p2.getPrice()) {
                return -1;
            }
            if (p1.getPrice() == p2.getPrice()) {
                return 0;
            } else return 1;
        }
    }

    public boolean refundProduct(Product product) {
        return true;
    }
}
