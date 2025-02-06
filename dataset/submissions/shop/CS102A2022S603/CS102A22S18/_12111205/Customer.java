import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet=this.wallet+amount;
    }

    public boolean purchaseProduct (Store store, Product product) {
        if(store.hasProduct(product) && this.wallet>= product.getPrice()){
            updateWallet(-product.getPrice());
            product.SetProductStoreName(store);
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product:shoppingCart){
                System.out.println(product);
            }
        }
        if(sortMethod.equals(SortBy.Rating)){
            for (int i=0;i<shoppingCart.size()-1;i++){
                for (int j=0;j<shoppingCart.size()-1-i;j++){
                    if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(j+1).getAvgRating()){
                        Collections.swap(shoppingCart,j,j+1);
                    }
                }
            }
            for (Product product:shoppingCart){
                 System.out.println(product);
            }
        }
        if(sortMethod.equals(SortBy.Price)){
            for (int i=0;i<shoppingCart.size()-1;i++){
                for (int j=0;j<shoppingCart.size()-1-i;j++){
                    if (shoppingCart.get(j).getPrice() > shoppingCart.get(j+1).getPrice()){
                        Collections.swap(shoppingCart,j,j+1);
                    }
                }
            }
            for (Product product:shoppingCart) {
                 System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        boolean result;
        if (this.shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            product.getProductStoreName().transact(product,1);
            result=true;
        }
        else{
            result=false;
        }
        return result;
    }
}
