import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        this.id = ++cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                shoppingCart.forEach(System.out::println);
                break;
            case Rating:
                shoppingCart.stream()
                        .sorted((o1, o2) -> (int) Math.signum (o1.getAvgRating() - o2.getAvgRating()))
                        .forEach(System.out::println);
                break;
            case Price:
                shoppingCart.stream()
                        .sorted((o1, o2) -> (int) Math.signum (o1.getPrice() - o2.getPrice()))
                        .forEach(System.out::println);
                break;
        }
    }

    public boolean refundProduct(Product product) {
        if (!shoppingCart.contains(product))
            return false;
        product.getStore().transact(product, 1);
        shoppingCart.remove(product);
        wallet += product.getPrice();
        return true;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }
}
