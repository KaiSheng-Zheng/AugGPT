import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private int t = 0;

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
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product)) {
            if (wallet >= product.getPrice()) {
                store.transact(product,0);
                shoppingCart.add(product);
                wallet -= product.getPrice();
                product.store = store;
                product.time = t;
                t++;
                return true;}}
        return false;}

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod==SortBy.PurchaseTime) {
            for (Product p:shoppingCart){
                System.out.println(p);
            }
        }
       if (sortMethod==SortBy.Rating){
            Collections.sort(shoppingCart, Comparator.comparingDouble(Product::getAvgRating).thenComparingInt(Product::getTime));
            for (Product p:shoppingCart){
                System.out.println(p);
            }
        }
        if (sortMethod==SortBy.Price){
            Collections.sort(shoppingCart, Comparator.comparingDouble(Product::getPrice).thenComparingInt(Product::getTime));
            for (Product p:shoppingCart){
                System.out.println(p);
            }
        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            wallet += product.getPrice();
            shoppingCart.remove(product);
            product.store.transact(product,1);
            return true;}
        else {
            return false;}
    }

}