import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private ArrayList<Store> shoppingStores = new ArrayList<>();

    public Customer(String name, float wallet) {
        this.name = name;
        this.id = ++ cnt;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product)) {
            if (this.wallet >= product.getPrice()) {
                this.wallet -= product.getPrice();
                this.shoppingCart.add(product);
                this.shoppingStores.add(store);
                store.transact(product, 0);
                return true;
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shoppingCartView = new ArrayList<>(this.shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            shoppingCartView = this.shoppingCart;
        } else if (sortMethod == SortBy.Rating) {
            shoppingCartView.sort((o1, o2) -> {
                // TODO Auto-generated method stub
                return Float.compare(o1.getAvgRating(), o2.getAvgRating());
            });
        } else {
            shoppingCartView.sort((o1, o2) -> {
                // TODO Auto-generated method stub
                return Float.compare(o1.getPrice(), o2.getPrice());
            });
        }
        for (Product product : shoppingCartView) {
            System.out.println(product);
        }
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            this.wallet += product.getPrice();

            for (int i = 0; i < this.shoppingCart.size(); i++) {
                Product productNow = this.shoppingCart.get(i);
                if (productNow.equals(product)) {
                    Store store = this.shoppingStores.get(i);
                    store.transact(product, 1);
                    this.shoppingCart.remove(product);
                    this.shoppingStores.remove(store);
                    break;
                }
            }

            return true;
        }
        return false;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }
}