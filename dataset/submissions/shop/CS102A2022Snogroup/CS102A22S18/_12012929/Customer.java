import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        id = ++cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            product.setStore(store);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case Price:
                ArrayList<Product> list1 = new ArrayList<>(shoppingCart);
                list1.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return Float.compare(o1.getPrice(), o2.getPrice());
                    }
                });
                for (Product product : list1)
                    System.out.println(product);
                break;
            case Rating:
                ArrayList<Product> list2 = new ArrayList<>(shoppingCart);
                list2.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return Float.compare(o1.getAvgRating(), o2.getAvgRating());
                    }
                });
                for (Product product : list2)
                    System.out.println(product);
                break;
            case PurchaseTime:
                for (Product product : shoppingCart)
                    System.out.println(product);
                break;
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            product.getStore().transact(product, 1);
            shoppingCart.remove(product);
            wallet += product.getPrice();
            return true;
        }
        return false;
    }
}
