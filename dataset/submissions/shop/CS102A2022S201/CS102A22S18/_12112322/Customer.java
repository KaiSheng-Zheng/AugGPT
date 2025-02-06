import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        boolean a=product.setRating(rating);
        return a;
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)==true&&wallet>product.getPrice()){
            store.transact(product,0);shoppingCart.add(product);updateWallet(-product.getPrice());return true;}
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod== SortBy.PurchaseTime){
            for (Product product:shoppingCart){
                System.out.println(product.toString());
            }
        }
        if (sortMethod==SortBy.Rating){
            Collections.sort(shoppingCart, new Compare());
            for (Product product:shoppingCart){
                System.out.println(product.toString());
            }
        }
        if (sortMethod==SortBy.Price){
            Collections.sort(shoppingCart,new Compare1());
            for (Product product:shoppingCart){
                System.out.println(product.toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }

}
