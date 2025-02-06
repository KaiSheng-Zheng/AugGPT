import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
        cnt = cnt +1;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
        this.shoppingCart = new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet = wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && this.wallet>=product.getPrice()){
            product.setFrom(store);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            return true;
        }
        else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for(int i = 0; i<= shoppingCart.size()-1; i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if(sortMethod == SortBy.Price){
            float a[] = new float[shoppingCart.size()];
            for(int i = 0; i<= shoppingCart.size()-1; i++){
                a[i] = shoppingCart.get(i).getPrice();
            }
            float m = 0;
            for(int i = 0; i<= shoppingCart.size()-1; i++){
                for(int k = i; k<= shoppingCart.size()-1; k++){
                    if(a[i] > a[k]){
                        m = a[k];
                        a[k] = a[i];
                        a[i] = m;
                       Collections.swap(shoppingCart,i,k);
                    }
                }
            }
            for(int i = 0; i<= shoppingCart.size()-2; i++){
                if(shoppingCart.get(i).getPrice()==shoppingCart.get(i+1).getPrice()&&shoppingCart.get(i).getId()>shoppingCart.get(i+1).getId())
                {
                    Collections.swap(shoppingCart,i,i+1);
                }
            }
            for(int i = 0; i <= shoppingCart.size()-1; i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if(sortMethod == SortBy.Rating){
            float a[] = new float[shoppingCart.size()];
            for(int i = 0; i<= shoppingCart.size()-1; i++){
                a[i] = shoppingCart.get(i).getAvgRating();
            }
            float m = 0;
            for(int i = 0; i<= shoppingCart.size()-1; i++){
                for(int k = i; k<= shoppingCart.size()-1; k++){
                    if(a[i] > a[k]){
                        m = a[k];
                        a[k] = a[i];
                        a[i] = m;
                        Collections.swap(shoppingCart,i,k);
                    }
                }
            }
            for(int i = 0; i<= shoppingCart.size()-2; i++){
                if(shoppingCart.get(i).getAvgRating()==shoppingCart.get(i+1).getAvgRating()&&shoppingCart.get(i).getId()>shoppingCart.get(i+1).getId())
                {
                    Collections.swap(shoppingCart,i,i+1);
                }
            }
            for(int i = 0; i <= shoppingCart.size()-1; i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        int k = 0;
        for(int i = 0; i<= shoppingCart.size()-1; i++){
            if(product == shoppingCart.get(i)){
                k = 1;
                break;
            }
        }
        if(k == 1){
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            product.getFrom().transact(product,1);
            return true;
        }
        else{
            return false;
        }
    }



}
