import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;


    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        float income;
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            wallet = wallet - product.getPrice();
            shoppingCart.add(product);
            store.removeProduct(product);
            store.transact(product,0);
            return true;
        } else {
            return false;
        }
    }

    public enum SortBy {
        PurchaseTime, Rating, Price
    }

    public void viewShoppingCart(SortBy sortMethod) {


    }

    /*public boolean refundProduct(Product product) {
if(purchaseProduct()){
    return true;
}else{
    return false;
}*/
}

