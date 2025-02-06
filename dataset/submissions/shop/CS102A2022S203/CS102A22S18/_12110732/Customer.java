import java.util.ArrayList;
public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet=wallet;
        cnt++;
        this.id= cnt;
    }
    public boolean rateProduct(Product product, int rating){
        boolean result = false;
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5)
        {
            result = true;
            product.setRating(rating);
        }
        return result;
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
        this.wallet=wallet;
    }
    public boolean purchaseProduct(Store store, Product product){
            if(store.hasProduct(product)&&wallet>=product.getPrice())
            {   wallet-=product.getPrice();
                shoppingCart.add(product);
                store.setIncome(product.getPrice());
                store.removeProduct(product);
                return true;
            }
            else
            {
                return false;
            }
    }
    public void viewShoppingCart(SortBy sortMethod) {
    }
    public boolean refundProduct(Product product){
        return true;
    }
}