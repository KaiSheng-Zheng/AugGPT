import java.util.ArrayList;
import java.util.Comparator;

public class Customer {

    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        this.id = cnt++;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        } else {
            product.setRating(rating);
            return true;
        }
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            store.transact(product, 0);
            wallet -= product.getPrice();

            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.Price)) {
            ArrayList<Product> productInPrice = new ArrayList<>(shoppingCart.size());
            for (Product product : shoppingCart) {
                productInPrice.add(product);
            }

            productInPrice.sort(Comparator.comparingDouble(Product::getPrice));
            for (int i = 0; i < productInPrice.size(); i++) {
                System.out.println(productInPrice);

            }
        }
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating)) {
            ArrayList<Product> productInRating = new ArrayList<>(shoppingCart.size());
            for (Product product : shoppingCart) {
                productInRating.add(product);
            }
            productInRating.sort(Comparator.comparingDouble(Product::getAvgRating));

            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(productInRating);
            }

        }
    }
}