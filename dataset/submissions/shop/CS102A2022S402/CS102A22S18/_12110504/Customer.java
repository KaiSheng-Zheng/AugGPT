import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private ArrayList<Store> stores = new ArrayList<>();


    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;

    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) return true;
        return false;
    }


    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            product.setFrom(store.getId());
            stores.add(store);
            return true;
        }
        return false;

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
        if (!shoppingCart.contains(product)) return false;
        for (int i = 0; i < stores.size(); i++) {
            if (product.getFrom() == stores.get(i).getId()) {
                shoppingCart.remove(product);
                updateWallet(product.getPrice());
                stores.get(i).transact(product, 1);
                return true;
            }
        }
        return false;
    }

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