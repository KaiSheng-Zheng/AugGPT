import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
    this.name = name;
    this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if(rating == 1|| rating ==2 || rating == 3 || rating == 4 || rating == 5){
            product.setRating(rating);
        return true;}
        else
            return false;
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(wallet > product.getPrice() && store.hasProduct(product)){
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.removeProduct(product);
            return true;
        }
        else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod){

    }
    public boolean refundProduct(Product product){
        wallet += product.getPrice();
        shoppingCart.remove(product);
        return true;
    }

}
