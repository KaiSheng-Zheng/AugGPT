import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
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
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.wallet -= product.getPrice();
            this.shoppingCart.add(product);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product p : shoppingCart) System.out.println(p);
        } else if (sortMethod == SortBy.Rating) {
            ArrayList<Product> temp = new ArrayList<>(shoppingCart);
            temp.sort((o1, o2) -> {
                if (o1.getAvgRating() > o2.getAvgRating()) return 1;
                else if (o1.getAvgRating() < o2.getAvgRating()) return -1;
                return 0;
            });
            for (Product p: temp) System.out.println(p);
        } else {
            ArrayList<Product> temp = new ArrayList<>(shoppingCart);
            temp.sort((o1, o2) -> {
                if (o1.getPrice() > o2.getPrice()) return 1;
                else if (o1.getPrice() < o2.getPrice()) return -1;
                return 0;
            });
            for (Product p: temp) System.out.println(p);
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            product.store.transact(product, 1);
            wallet += product.getPrice();
            shoppingCart.remove(product);
            return true;
        }return false;
    }

}

