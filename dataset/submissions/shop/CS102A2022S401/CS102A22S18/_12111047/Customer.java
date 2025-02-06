import java.util.ArrayList;
import java.util.HashMap;

public class Customer {

    private static int cnt = 0;

    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    private HashMap<Product, Store> purchasedHistory = new HashMap<>();

    public Customer(String name, float wallet) {
        Customer.cnt++;
        this.id = Customer.cnt;
        this.shoppingCart = new ArrayList<>();
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            this.purchasedHistory.put(product, store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> tempList = (ArrayList<Product>) this.shoppingCart.clone();
        switch (sortMethod) {
            case PurchaseTime:
                for (Product product : tempList) {
                    System.out.println(product);
                }
                break;
            case Rating:
                tempList.sort((x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
                for (Product product : tempList) {
                    System.out.println(product);
                }
                break;
            case Price:
                tempList.sort((x, y) -> Float.compare(x.getPrice(), y.getPrice()));
                for (Product product : tempList) {
                    System.out.println(product);
                }
                break;
            default:

        }
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
            this.wallet += product.getPrice();
            this.purchasedHistory.get(product).transact(product, 1);
            this.purchasedHistory.remove(product);
            return true;
        }
        return false;
    }

}
