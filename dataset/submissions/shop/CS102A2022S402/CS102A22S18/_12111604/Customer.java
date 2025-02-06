import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart= new ArrayList<Product>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5) {
            product.setRating(rating);
            return true;
        }
        return false;
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet>= product.getprice()){
            shoppingCart.add(product);
            store.removeProduct(product);
            store.setIncome(store.getIncome()+ product.getprice());
            updateWallet(product.getprice()*(-1));
            return true;
        }else return false;
    }
    public enum SortBy {
        PurchaseTime, Rating, Price
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                }
                break;
            case Rating:
                Product[] it = new Product[shoppingCart.size()];
                for (int i = 0;i<shoppingCart.size();i++){
                }

                for (int i = 0; i < shoppingCart.size(); i++) {
                }
                break;
            case Price:

                for (int i = 0;i<shoppingCart.size();i++){
                }
                for (int i = 0; i < shoppingCart.size(); i++) {

                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.getprice();
            return true;
        }else return false;
    }
}
