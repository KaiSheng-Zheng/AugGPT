import java.util.ArrayList;
import java.util.HashMap;

public class Customer {

    private static int cnt = 0;

    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    private HashMap<Product, Store> purchaseList = new HashMap<>();

    public Customer(String name, float wallet) {
        cnt++;
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
            this.purchaseList.put(product, store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] tmp = new Product[shoppingCart.size()];
        for (int i = 0; i < shoppingCart.size(); i++) {
            tmp[i] = shoppingCart.get(i);
        }
        switch (sortMethod) {
            case PurchaseTime: {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            }
            case Rating: {
               if (tmp.length>1) {
                for (int i = 0; i < tmp.length - 1; i++) {
                    for (int j = i + 1; j < tmp.length; j++) {
                        Product tmpProduct = tmp[i];
                        if (tmp[j].getAvgRating() < tmpProduct.getAvgRating()) {
                            tmp[i] = tmp[j];
                            tmp[j] = tmpProduct;
                        }
                    }
                }}
                for (int i = 0; i < tmp.length; i++) {
                    System.out.println(tmp[i].toString());
                }
                break;
            }
            case Price: {
                if (tmp.length>1) {
                    for (int i = 0; i < tmp.length - 1; i++) {
                    for (int j = i + 1; j < tmp.length; j++) {
                        Product tmpProduct = tmp[i];
                        if (tmp[j].getPrice() < tmpProduct.getPrice()) {
                            tmp[i] = tmp[j];
                            tmp[j] = tmpProduct;
                        }
                    }
                }}
                for (int i = 0; i < tmp.length; i++) {
                    System.out.println(tmp[i].toString());
                }
                break;
            }
            default:

        }
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
            this.wallet += product.getPrice();
            this.purchaseList.get(product).transact(product, 1);
            this.purchaseList.remove(product);
            return true;
        }
        return false;
    }

}