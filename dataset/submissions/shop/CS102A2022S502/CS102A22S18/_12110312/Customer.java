import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> storesHistory;

    public Customer(String name, float wallet) {
        Customer.cnt++;
        this.id = Customer.cnt;
        this.name = name;
        this.shoppingCart = new ArrayList<Product>();
        this.wallet = wallet;
        this.storesHistory = new ArrayList<Store>();
    }

    public boolean rateProduct(Product p, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        p.setRating(rating);
        return true;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product p) {
        if (store.hasProduct(p) && this.wallet >= p.getPrice()) {
            this.shoppingCart.add(p);
            this.wallet -= p.getPrice();
            store.transact(p, 0);
            this.storesHistory.add(store);
            return true;
        }
        else {
            return false;
        }
    }



    public void viewShoppingCart(SortBy sortMethod) {
        Product[] shoppingCartArray = this.shoppingCart.toArray(new Product[this.shoppingCart.size()]);
        switch (sortMethod) {
            case PurchaseTime:
                for (Product p : shoppingCartArray) {
                    System.out.println(p.toString());
                }
                break;
            case Rating:
                Arrays.sort(shoppingCartArray, (p1, p2) -> Float.compare(p1.getAvgRating(), p2.getAvgRating()));
                for (Product p : shoppingCartArray) {
                    System.out.println(p.toString());
                }
                break;
            case Price:
                Arrays.sort(shoppingCartArray, (p1, p2) -> Float.compare(p1.getPrice(), p2.getPrice()));
                for (Product p : shoppingCartArray) {
                    System.out.println(p.toString());
                }
                break;
        }
    }

    public boolean refundProduct(Product p) {
        if (this.shoppingCart.contains(p)) {
            this.storesHistory.get(this.shoppingCart.indexOf(p)).transact(p, 1);
            this.storesHistory.remove(this.shoppingCart.indexOf(p));
            this.shoppingCart.remove(p);
            this.wallet += p.getPrice();
            return true;
        }
        else {
            return false;
        }
    }
}
