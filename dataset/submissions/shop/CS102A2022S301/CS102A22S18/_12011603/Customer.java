import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Product, Store> place = new HashMap<>();
    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            store.transact(product, 0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            place.put(product, store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for(Product p : shoppingCart){
                System.out.println(p);
            }
        }
        if(sortMethod.equals(SortBy.Rating)){
            ArrayList<Product> list = new ArrayList<>(shoppingCart);
            list.sort(Comparator.comparingDouble(Product::getAvgRating));
            for(Product p: list){
                System.out.println(p);
            }
        }
        if(sortMethod.equals(SortBy.Price)){
            ArrayList<Product> list = new ArrayList<>(shoppingCart);
            list.sort(Comparator.comparingDouble(Product::getPrice));
            for(Product p: list){
                System.out.println(p);
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)){
            Store store = place.get(product);
            store.transact(product, 1);
            wallet += product.getPrice();
            shoppingCart.remove(product);
            return true;
        }
        return false;
    }
}
