import java.util.ArrayList;
import java.util.Comparator;


public class Customer {
    private static int cnt;
    private int id = 1;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;


    public Customer(String name, float wallet) {
        this.wallet = wallet;
        this.name = name;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        product.setRating(rating);
        if (rating >= 1 && rating <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.removeProduct(product);
            store.transact(product, 0);
            System.out.println(wallet);
            product.setStore(store);
            shoppingCart.add(product);
            wallet -= product.getPrice();
            return true;
        } else {
            return false;
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            product.getStore().transact(product, 1);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case Price:
                shoppingCart.sort(Comparator.comparing(Product::getPrice));
                for (Product product:shoppingCart) {
                    System.out.println(product);
                }
                break;
            case Rating:
                shoppingCart.sort(Comparator.comparing(Product::getAvgRating));
                for (Product product:shoppingCart) {
                    System.out.println(product);
                }
                break;
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
                break;
        }
    }
}
