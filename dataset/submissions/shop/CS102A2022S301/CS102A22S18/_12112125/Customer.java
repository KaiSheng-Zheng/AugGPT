
import java.util.ArrayList;


public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            product.setStore(store);
            store.transact(product, 0);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            shoppingCart.forEach(System.out::println);
        }
        if (sortMethod == SortBy.Rating) {
            ArrayList<Product> shopcar = new ArrayList<>(getShoppingCart());
            shopcar.sort((p1, p2) -> Float.compare(p1.getAvgRating(), p2.getAvgRating()));
            shopcar.forEach(System.out::println);
            }
        if (sortMethod == SortBy.Price) {
            ArrayList<Product> shopcar = new ArrayList<>(getShoppingCart());
            shopcar.sort((p1, p2) -> Float.compare(p1.getPrice(), p2.getPrice()));
            shopcar.forEach(System.out::println);
        }
    }

    public boolean refundProduct(Product product) {
        boolean bought = false;
        for (Product p : shoppingCart) {
            if (p.getId() == product.getId()) {
                bought = true;
                break;
            }
        }
        if (bought) {
            product.getStore().transact(product, 1);
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
        }
        return bought;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

}
