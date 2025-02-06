import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name , float wallet){
        cnt ++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (wallet < product.getPrice() || !store.hasProduct(product))
            return false;
        store.transact(product, 0);
        shoppingCart.add(product);
        updateWallet(-(product.getPrice()));
        return true;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            double kk = 1E-6;
            ArrayList<Product> cart = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++){
                cart.add(shoppingCart.get(i));
            }
            for (int i = 0; i < cart.size(); i++){
                for (int j = 0; j < cart.size() - i - 1; j++) {
                    if (!(Math.abs(cart.get(j).getAvgRating() - cart.get(j + 1).getAvgRating()) < kk)) {
                        if (cart.get(j).getAvgRating() > cart.get(j + 1).getAvgRating())
                            Collections.swap(cart, j, j + 1);
                    }
                }
            }
            for (int i = 0; i < cart.size(); i++){
                System.out.println(cart.get(i).toString());
            }

        }
        if (sortMethod == SortBy.Price){
            double kk = 1E-6;
            ArrayList<Product> cart = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++){
                cart.add(shoppingCart.get(i));
            }
            for (int i = 0; i < cart.size(); i++){
                for (int j = 0; j < cart.size() - i - 1; j++) {
                    if (!(Math.abs(cart.get(j).getPrice() - cart.get(j + 1).getPrice()) < kk)) {
                        if (cart.get(j).getPrice() > cart.get(j + 1).getPrice())
                            Collections.swap(cart, j, j + 1);
                    }
                }
            }
            for (int i = 0; i < cart.size(); i++){
                System.out.println(cart.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product))
            return false;
        updateWallet((product.getPrice()));
        shoppingCart.remove(product);
        product.getStore().transact(product,1);
        return true;
    }
}