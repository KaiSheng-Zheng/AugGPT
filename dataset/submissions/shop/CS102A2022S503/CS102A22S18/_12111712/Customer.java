import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.shoppingCart = new ArrayList<Product>();
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating) {
        if (rating < 0 || rating > 5) {
            return false;
        }
        product.setRating(rating);
        return true;
    }
    public void updateWallet(float amount) {
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if(this.wallet >= product.getPrice() && store.hasProduct(product)) {
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            store.removeProduct(product);
            store.transact(product,0);
            return true;
        }else {
            return false;
        }
    }
//    public enum SortBy{
//        PurchaseTime, Rating, Price
//    }
    public void viewShoppingCart(SortBy sortBy) {
        List<Product> products = new ArrayList<Product>(this.shoppingCart);
        switch (sortBy) {
            case PurchaseTime:
                break;

            case Rating:
                products.sort(Comparator.comparing(Product::getAvgRating));
                break;
            case Price:
                products.sort(Comparator.comparing(Product::getPrice));
                break;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
            product.getStore().transact(product,1);
            this.wallet += product.getPrice();
            return true;
        }
        return false;
    }


}


