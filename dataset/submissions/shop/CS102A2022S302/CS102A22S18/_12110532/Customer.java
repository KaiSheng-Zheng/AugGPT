import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        boolean n;
        if (product.setRating(rating)) {
            n = true;
        } else {
            n = false;
        }
        return n;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean n;
        if (store.getProductList().contains(product) && wallet >= product.getPrice()) {
            store.removeProduct(product);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            n = true;
        } else {
            n = false;
        }
        return n;
    }

    class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return Float.compare(o1.getAvgRating(), o2.getAvgRating());
        }
    }

    class SortByPrice implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return Float.compare(o1.getPrice(), o2.getPrice());
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating)) {
            ArrayList<Product> newshoppingCart = new ArrayList<>(shoppingCart);
            newshoppingCart.sort(new SortByRating());
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(newshoppingCart.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)) {
            ArrayList<Product> newshoppingCart = new ArrayList<>(shoppingCart);
            newshoppingCart.sort(new SortByPrice());

            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(newshoppingCart.get(i).toString());
            }
        }

    }

    public boolean refundProduct(Product product) {
        boolean n;
        if (shoppingCart.contains(product)) {
            n = true;
        } else {
            n = false;
        }
        return n;
    }
}
