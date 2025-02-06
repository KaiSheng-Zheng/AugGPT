import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Customer {

    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    // The list of purchased products; default is empty.
    private float wallet;

    private HashMap<Product, Store> purchasedRecord = new HashMap<>();

    public Customer(String name, float wallet) {
        Customer.cnt += 1;
        this.id = Customer.cnt;
        this.shoppingCart = new ArrayList<>();
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating))
            return true;
        else
            return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product)) {
            if (this.wallet >= product.getPrice()) {
                shoppingCart.add(product);
                wallet -= product.getPrice();
                store.transact(product, 0);
                purchasedRecord.put(product, store);
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> cart = new ArrayList<>(shoppingCart);

        switch (sortMethod) {
            case PurchaseTime:
                for (Iterator i = cart.listIterator(); i.hasNext();) {
                    Product product = (Product) i.next();
                    System.out.println(product);
                }
                break;

            case Rating:
                cart.sort((x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
                for (Iterator i = cart.listIterator(); i.hasNext();) {
                    Product product = (Product) i.next();
                    System.out.println(product);
                }
                break;

            case Price:
                cart.sort((x, y) -> Float.compare(x.getPrice(), y.getPrice()));
                for (Iterator i = cart.listIterator(); i.hasNext();) {
                    Product product = (Product) i.next();
                    System.out.println(product);
                }
                break;

            default:
        }
    }

    public boolean refundProduct (Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            purchasedRecord.get(product).transact(product, 1);
            purchasedRecord.remove(product);
            return true;
        }
        return false;
    }
}
