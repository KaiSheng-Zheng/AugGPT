import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.wallet = wallet;
        this.name = name;
    }

    public boolean rateProduct(Product product, int rating) {
        if(rating >= 1 && rating <= 5){
            product.setRating(rating);
            return true;
        }
        else return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if(wallet >= product.getPrice() && store.hasProduct(product)){
            shoppingCart.add(product);
            wallet = wallet - product.getPrice();
            store.transact(product,0);
            return true;
        }
        else {return false;}
    }

    public void viewShoppingCart(SortBy sortMethod) {
    }

    public boolean refundProduct(Product product) {
        return false;
    }
}
