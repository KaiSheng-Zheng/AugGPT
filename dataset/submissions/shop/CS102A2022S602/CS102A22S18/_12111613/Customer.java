import java.util.ArrayList;

enum SortBy {
    PurchaseTime, Rating, Price
}


public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        boolean ratesuccess = product.setRating(rating);
        return ratesuccess;
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) & wallet > product.getPrice()){
            shoppingCart.add(product);
            wallet = wallet - product.getPrice();
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){

    }
}
