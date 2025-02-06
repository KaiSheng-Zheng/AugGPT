import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet = 0;
    private HashMap<Product, Store> whichStore = new HashMap<Product, Store>();

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            whichStore.put(product, store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> beSorted = new ArrayList<Product>();
        for (int i = 0; i < shoppingCart.size(); i++) {
            beSorted.add(shoppingCart.get(i));
        }
        if (sortMethod == SortBy.PurchaseTime) {
            beSorted.sort(timeSort);
        } else if (sortMethod == SortBy.Price) {
            beSorted.sort(priceSort);
        } else if (sortMethod == SortBy.Rating) {
            beSorted.sort(rateSort);
        }
        for (int i = 0; i < beSorted.size(); i++) {
            System.out.println(beSorted.get(i));
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            Store store = whichStore.get(product);
            whichStore.remove(product, store);
            updateWallet(product.getPrice());
            store.transact(product, 1);
            return true;
        } else {
            return false;
        }
    }

    Comparator<Product> timeSort = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return shoppingCart.indexOf(o1) - (shoppingCart.indexOf(o2));
        }
    };

    Comparator<Product> rateSort = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            double r1 = o1.getAvgRating(), r2 = o2.getAvgRating();
            if (r1 > r2) {
                return 1;
            } else if (r1 < r2) {
                return -1;
            } else {
                return shoppingCart.indexOf(o1) - (shoppingCart.indexOf(o2));
            }
        }
    };

    Comparator<Product> priceSort = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            double r1 = o1.getPrice(), r2 = o2.getPrice();
            if (r1 > r2) {
                return 1;
            } else if (r1 < r2) {
                return -1;
            } else {
                return shoppingCart.indexOf(o1) - (shoppingCart.indexOf(o2));
            }
        }
    };
}
