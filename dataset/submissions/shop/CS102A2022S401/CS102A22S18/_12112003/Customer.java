import java.util.*;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Store> stores = new ArrayList<>();

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (wallet >= product.getPrice() && store.hasProduct(product)) {
            products.add(product);
            stores.add(store);
            store.transact(product, 0);
            shoppingCart.add(product);
            wallet -= product.getPrice();
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (Product x : shoppingCart) {
                    System.out.println(x);
                }
                break;
            case Price:
                ArrayList<Product> cloneS = new ArrayList<>(shoppingCart);
                PriceComparator oi = new PriceComparator();
                Collections.sort(cloneS, oi);
                for (int i = 0; i < cloneS.size(); i++) {
                    Product pri = cloneS.get(i);
                    System.out.println(pri);
                }
                break;
            case Rating:
                ArrayList<Product> cloneR = new ArrayList<>(shoppingCart);
                RatingComparator oj = new RatingComparator();
                Collections.sort(cloneR, oj);
                for (int i = 0; i < cloneR.size(); i++) {
                    Product pri = cloneR.get(i);
                    System.out.println(pri);
                }
                break;

        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            wallet += product.getPrice();
            shoppingCart.remove(product);
            stores.get(products.indexOf(product)).transact(product, 1);
            return true;
        } else {
            return false;
        }
    }
}
enum SortBy {
    PurchaseTime, Rating, Price
}
