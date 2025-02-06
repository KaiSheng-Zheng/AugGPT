import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Product,Store > order = new HashMap<>();


    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            this.order.put(product,store );
            this.updateWallet(-product.getPrice());
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> products = new ArrayList<>(shoppingCart);

        if (sortMethod.equals(SortBy.PurchaseTime)) {
            products.sort(Comparator.comparingInt(o -> shoppingCart.indexOf(o)));
        }
        if (sortMethod.equals(SortBy.Rating)) {
            products.sort((o1, o2) -> {
                if (o1.getAvgRating() > o2.getAvgRating()) {
                    return 1;
                } else if (o1.getAvgRating() < o2.getAvgRating()) {
                    return -1;
                } else {
                    return shoppingCart.indexOf(o1) - shoppingCart.indexOf(o2);
                }
            });
        }

        if (sortMethod.equals(SortBy.Price)) {
            products.sort((o1, o2) -> {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else {
                    return shoppingCart.indexOf(o1) - shoppingCart.indexOf(o2);
                }
            });
        }

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }

    }

    public int getId() {
        return id;
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
                this.shoppingCart.remove(product);
                this.updateWallet(product.getPrice());
                order.get(product).transact(product, 1);
                order.remove(product);
                return true;
        }
        return false;
    }

}
