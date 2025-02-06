import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private Map<Product, Store> note;

    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.wallet = wallet;
        this.name = name;
        this.note = new HashMap<>();
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= this.wallet) {
            this.updateWallet(-product.getPrice());
            shoppingCart.add(product);
            note.put(product, store);
            store.transact(product, 0);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product p : shoppingCart) {
                System.out.println(p);
            }
        } else if (sortMethod == SortBy.Rating) {
            Product[] products = shoppingCart.toArray(new Product[shoppingCart.size()]);
            Arrays.sort(products, new SortBy.SortByRating());
            for (Product p : products) {
                System.out.println(p);
            }
        } else if (sortMethod == SortBy.Price) {
            Product[] products = shoppingCart.toArray(new Product[shoppingCart.size()]);
            Arrays.sort(products, new SortBy.SortByPrice());
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    public boolean refundProduct(Product product) {
        if(!shoppingCart.contains(product)) return false;

        wallet += product.getPrice();
        shoppingCart.remove(product);
        Store s = note.get(product);
        note.remove(product);
        s.transact(product, 1);
        return true;
    }
}

enum SortBy {
    PurchaseTime, Rating, Price;

    static class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            float a = o1.getAvgRating() - o2.getAvgRating();
            if (a != 0)
                return a < 0 ? -1 : 1;
            return 0;
        }
    }

    static class SortByPrice implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            float a = o1.getPrice() - o2.getPrice();
            if (a != 0)
                return a < 0 ? -1 : 1;
            return 0;
        }

    }
}
