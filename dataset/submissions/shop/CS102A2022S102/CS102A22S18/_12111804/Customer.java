import java.util.ArrayList;
public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt += 1;
        id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        product.setRating(rating);
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if(store.hasProduct(product)&&wallet>=product.getPrice()) {
            store.transact(product, 0);
            shoppingCart.add(product);
            return true;
        }
        else
            return false;
    }
    public enum SortBy {
        PurchaseTime, Rating, Price;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.Price){
            for (Product d : shoppingCart){

            }
        }
    }
}
