import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
        shoppingCart = new ArrayList<Product>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            product.setStore(store);
            shoppingCart.add(product);
            store.transact(product, 0);
            wallet -= product.getPrice();
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
        if (sortMethod == SortBy.Rating) {
            ArrayList<Product> k = new ArrayList<>(shoppingCart);
            for (int j = 0; j < 5000; j++) {
                for (int i = 0; i < k.size() - 1; i++) {
                    if (k.get(i).getAvgRating() > k.get(i + 1).getAvgRating()) {
                        Collections.swap(k, i, i + 1);
                    }
                }
            }

            for (int j = 0; j < k.size(); j++) {
                System.out.println(k.get(j));
            }
        }
        if (sortMethod == SortBy.Price) {
            ArrayList<Product> k = new ArrayList<>(shoppingCart);
            for (int j = 0; j <5000 ; j++) {
                for (int i = 0; i < k.size() - 1; i++) {
                    if (k.get(i).getPrice() > k.get(i + 1).getPrice()) {
                        Collections.swap(k, i, i + 1);
                    }
                }
            }

            for (int i = 0; i < k.size(); i++) {
                System.out.println(k.get(i));
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            product.getStore().transact(product, 1);
            wallet += product.getPrice();
            shoppingCart.remove(product);
            return true;
        } else return false;
    }

}
