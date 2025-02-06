import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;
    // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product,0);
            shoppingCart.add(product);
            wallet -= product.getPrice();
            product.store = store;
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> sorted = new ArrayList<>(shoppingCart);
        if(sortMethod == SortBy.PurchaseTime){
            for(Product product:sorted){
                System.out.println(product.toString());
            }
        } else if(sortMethod == SortBy.Rating) {
            sorted.sort(Comparator.comparingDouble(Product::getAvgRating));
            for(Product product:sorted){
                System.out.println(product.toString());
            }
        } else if(sortMethod == SortBy.Price){
            sorted.sort(Comparator.comparingDouble(Product::getPrice));
            for(Product product:sorted){
                System.out.println(product.toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            wallet += product.getPrice();
            shoppingCart.remove(product);
            product.store.transact(product,1);
            return true;
        } else
            return false;
    }
}

class SortByRating implements Comparator<Product>{

    @Override
    public int compare(Product o1,Product o2){
        return (int)(o1.getAvgRating()-(o2.getAvgRating()));
    }
}

class SortByPrice implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2){
        return (int) (o1.getPrice()-(o2.getPrice()));
    }
}