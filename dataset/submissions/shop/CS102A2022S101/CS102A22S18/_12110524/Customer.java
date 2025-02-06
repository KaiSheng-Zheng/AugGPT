import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id, time;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<Product>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }
    public void updateWallet(float amount) {
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            this.wallet -= product.getPrice();
            this.shoppingCart.add(product);
            product.setStore(store);
            store.transact(product, 0);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        for (int i = 0; i < shoppingCart.size(); i++) shoppingCart.get(i).setTime(i);
        switch (sortMethod) {
            case PurchaseTime:
                break;
            case Rating:
                shoppingCart.sort(new CompareRating());
                break;
            case Price:
                shoppingCart.sort(new ComparePrice());
                break;
        }
        for (int i = 0; i < shoppingCart.size(); i++) System.out.println(shoppingCart.get(i));
        shoppingCart.sort(new CompareTime());
    }
    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
            this.wallet += product.getPrice();
            product.getStore().transact(product, 1);
            return true;
        }
        else return false;
    }
}

class ComparePrice implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        float dif = p1.getPrice()-p2.getPrice();
        if (dif > 0) return 1;
        if (dif < 0) return -1;
        if (dif == 0) return p1.getTime() > p2.getTime() ? 1 : -1;
        return 0;
    }
}
class CompareRating implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        float dif = p1.getAvgRating()-p2.getAvgRating();
        if (dif > 0) return 1;
        if (dif < 0) return -1;
        if (dif == 0) return p1.getTime() > p2.getTime() ? 1 : -1;
        return 0;
    }
}
class CompareTime implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        float dif = p1.getTime()-p2.getTime();
        if (dif > 0) return 1;
        if (dif < 0) return -1;
        return 0;
    }
}