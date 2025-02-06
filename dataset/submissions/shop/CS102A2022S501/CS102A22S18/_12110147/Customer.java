import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Product,Store> UsedToRefund = new HashMap<Product,Store>();
    public Customer(String name, float wallet) {
        Customer.cnt++;
        this.id = Customer.cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            UsedToRefund.put(product,store);
            this.wallet = this.wallet - product.getPrice();
            store.transact(product,0);
            this.shoppingCart.add(product);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        //should add a check to handle the shoppingCart.size() == 0 case.
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0;i < this.shoppingCart.size();i++) {
                System.out.println(this.shoppingCart.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Price) {
            Product m = this.shoppingCart.get(0);
            Product[] p = new Product[this.shoppingCart.size()];
            for (int i = 0;i < this.shoppingCart.size();i++) {
                p[i] = this.shoppingCart.get(i);
            }
            for (int i = 0;i < p.length - 1;i++) {
                for (int j = 0;j < p.length - 1 - i;j++) {
                    if (p[j].getPrice() > p[j+1].getPrice()) {
                        m = p[j];
                        p[j] = p[j+1];
                        p[j+1] = m;
                    }
                }
            }
            for (int i = 0;i < p.length;i++) {
                System.out.println(p[i].toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            Product m = this.shoppingCart.get(0);
            Product[] p = new Product[this.shoppingCart.size()];
            for (int i = 0;i < this.shoppingCart.size();i++) {
                p[i] = this.shoppingCart.get(i);
            }
            for (int i = 0;i < p.length - 1;i++) {
                for (int j = 0;j < p.length - 1 - i;j++) {
                    if (p[j].getAvgRating() > p[j+1].getAvgRating()) {
                        m = p[j];
                        p[j] = p[j+1];
                        p[j+1] = m;
                    }
                }
            }
            for (int i = 0;i < p.length;i++) {
                System.out.println(p[i].toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            UsedToRefund.get(product).transact(product, 1);
            UsedToRefund.remove(product);
            this.shoppingCart.remove(product);
            this.wallet = this.wallet + product.getPrice();
            return true;
        }
        return false;
    }
}