import java.util.ArrayList;

public class Customer {

    private static int cnt = 0;
    private int id = cnt + 1;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> s = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.wallet = wallet;
        this.name = name;
        cnt++;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (wallet >= product.getPrice()){
            if (store.hasProduct(product)){
                store.transact(product,0);
                updateWallet(-product.getPrice());
                shoppingCart.add(product);
                s.add(store);
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        sortMethod.sort(this.shoppingCart);
    }

    public boolean refundProduct(Product product){
        if (!this.shoppingCart.contains(product))
            return false;
        else {
            Store a = s.get(shoppingCart.indexOf(product));
            a.transact(product,1);
            s.remove(shoppingCart.indexOf(product));
            wallet += product.getPrice();
            shoppingCart.remove(product);
            return true;
        }
    }
}
