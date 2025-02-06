import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private ArrayList<Store> shopping = new ArrayList<>();

    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            this.wallet = this.wallet - product.getPrice();
            store.transact(product, 0);
            shoppingCart.add(product);
            shopping.add(store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] b = new Product[shoppingCart.size()];
        Product c;
        for (int j = 0; j < shoppingCart.size(); j++) {
            b[j] = shoppingCart.get(j);
        }
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Price) {
            for (int i = 0; i < b.length; i++) {
                for (int j = b.length - 1; j > i; j--) {
                    if (b[j].getPrice() < b[j - 1].getPrice()) {
                        c = b[j - 1];
                        b[j - 1] = b[j];
                        b[j] = c;
                    }
                }
            }
            for (Product product : b) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < b.length; i++) {
                for (int j = b.length - 1; j > i; j--) {
                    if (b[j].getAvgRating() < b[j - 1].getAvgRating()) {
                        c = b[j - 1];
                        b[j - 1] = b[j];
                        b[j] = c;
                    }
                }
            }
            for (Product product : b) {
                System.out.println(product);
            }
        }
    }

    public boolean refundProduct(Product product) {
        int a = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i) == product) {
                a=1;
                shoppingCart.remove(product);
                this.wallet += product.getPrice();
                shopping.get(i).transact(product, 1);
                return true;
            }
        }
        return false;
    }
}
