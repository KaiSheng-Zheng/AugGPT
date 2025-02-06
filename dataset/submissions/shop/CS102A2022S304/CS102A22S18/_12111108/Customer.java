import java.util.*;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private Map<Product, Store> mapping;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        mapping = new HashMap<>();
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
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            mapping.put(product, store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> back = this.shoppingCart;
        if (sortMethod.equals(SortBy.PurchaseTime)) {

        } else if (sortMethod.equals(SortBy.Rating)) {
            Collections.sort(back, (o1, o2) -> {
                if (o1.getAvgRating() > o2.getAvgRating())
                    return 1;
                else if (o1.getAvgRating() < o2.getAvgRating())
                    return -1;
                else {
                    return shoppingCart.indexOf(o1) - shoppingCart.indexOf(o2);
                }
            });
        } else if (sortMethod.equals(SortBy.Price)) {
            Collections.sort(back, (o1, o2) -> {
                if (o1.getPrice() > o2.getPrice())
                    return 1;
                else if (o1.getPrice() < o2.getPrice())
                    return -1;
                else {
                    return shoppingCart.indexOf(o1) - shoppingCart.indexOf(o2);
                }
            });
        }
        for (Product p : back) {
            System.out.println(p);
        }
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            updateWallet(product.getPrice());
            this.shoppingCart.remove(product);
            Store store = mapping.get(product);
            store.transact(product, 1);
            return true;
        }
        return false;
    }
}
