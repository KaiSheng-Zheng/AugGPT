import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    // initialized to 0, and will increase by 1 when the constructor is called.
    private static int cnt = 0;
    // unique for each customer and the value is set to cnt.
    private int id;
    private String name;
    // The list of purchased products; default is empty.
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            store.transact(product, 0);
            updateWallet(product.getPrice() * -1);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Rating) {
            ArrayList<Product> tempShoppingCart = new ArrayList<>(shoppingCart);
            tempShoppingCart.sort(Comparator.comparing(Product::getAvgRating));
            for (Product product : tempShoppingCart) {
                System.out.println(product);
            }
        } else {
            ArrayList<Product> tempShoppingCart = new ArrayList<>(shoppingCart);
            tempShoppingCart.sort(Comparator.comparing(Product::getPrice));
            for (Product product : tempShoppingCart) {
                System.out.println(product);
            }
        }
    }

    public boolean refundProduct(Product product) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId() == product.getId()) {
                shoppingCart.remove(i);
                updateWallet(product.getPrice());
                product.getStore().transact(product, 1);
                return true;
            }
        }
        return false;
    }
}