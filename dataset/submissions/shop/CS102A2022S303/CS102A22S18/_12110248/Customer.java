import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        Customer.cnt++;
        this.id = Customer.cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    private HashMap<Product, Store> purchaseHistory = new HashMap<>();

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            this.purchaseHistory.put(product, store);
            return true;
        } else {
            return false;
        }

    }
    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            Store store = purchaseHistory.get(product);
            store.transact(product, 1);
            this.shoppingCart.remove(product);
            updateWallet(product.getPrice());
            this.purchaseHistory.remove(product);
            return true;
        } else {
            return false;
        }

    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] sortShoppingCart = new Product[shoppingCart.size()];
        ArrayList<Product> newProducts = new ArrayList<>();
        switch (sortMethod) {
///////
            case PurchaseTime: {
                newProducts.addAll(shoppingCart);
                System.out.println(newProducts);
                break;
            }
///////
            case Rating: {
                newProducts.addAll(shoppingCart);
                newProducts.sort(new SortByRating());
                System.out.println(newProducts);
                break;
            }
///////
            case Price: {
                newProducts.addAll(shoppingCart);
                newProducts.sort(new SortByPrice());
                System.out.println(newProducts);
                break;
            }
        }
    }

}

class SortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}

class SortByRating implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getAvgRating() <= o1.getAvgRating() ? 1 : -1;
    }
}

class SortByName implements Comparator<Product>{
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}