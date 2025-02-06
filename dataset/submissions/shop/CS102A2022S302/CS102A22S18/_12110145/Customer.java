import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Product, Store> purchasedHistory = new HashMap<>();

    public Customer(String name, float wallet) {
        Customer.cnt++;
        this.id = Customer.cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            this.purchasedHistory.put(product, store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] shopping = this.shoppingCart.toArray(new Product[0]);
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shopping) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Rating) {
            Arrays.sort(shopping, (x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
            for (Product product : shopping) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Price) {
            Arrays.sort(shopping, (x, y) -> Float.compare(x.getPrice(), y.getPrice()));
            for (Product product : shopping) {
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        if (this.shoppingCart.contains(product)){
            this.shoppingCart.remove(product);
            updateWallet(product.getPrice());
            this.purchasedHistory.get(product).transact(product, 1);
            return true;
        }else {
            return false;
        }
    }
}
