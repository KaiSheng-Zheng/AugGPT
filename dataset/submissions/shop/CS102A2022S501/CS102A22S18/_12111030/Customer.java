import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();
    private float wallet;

    public Customer(String name, float wallet){
        ++cnt;
        this.name=name;
        this.wallet=wallet;
        this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }else{
            return false;
        }
    }
    public void updateWallet(float amount){
        this.wallet=this.wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if((store.hasProduct(product))&&(this.wallet>=product.getPrice())){
            product.setStore(store);
            product.getStore().transact(product,0);
            this.wallet=wallet- product.getPrice();
            shoppingCart.add(product);

            return true;
        }else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.Rating){
            for(int i=0;i<shoppingCart.size();i++){
                for(int j=i+1;j<shoppingCart.size();j++){
                    if(shoppingCart.get(i).getAvgRating()>shoppingCart.get(j).getAvgRating()){
                        Product m = shoppingCart.get(i);
                        Product n = shoppingCart.get(j);
                        shoppingCart.set(j,m);
                        shoppingCart.set(i,n);
                    }
                    if(shoppingCart.get(i).getAvgRating()==shoppingCart.get(j).getAvgRating()){
                        if(shoppingCart.get(i).getPurchaseTime()<shoppingCart.get(j).getPurchaseTime()){
                            Collections.swap(shoppingCart,i,j);
                        }
                    }
                }
            }
        }
        if(sortMethod==SortBy.Price){
            for(int i=0;i<shoppingCart.size();i++){
                for(int j=i+1;j<shoppingCart.size();j++){
                    if(shoppingCart.get(i).getPrice()>shoppingCart.get(j).getPrice()){
                        Product m = shoppingCart.get(i);
                        Product n = shoppingCart.get(j);
                        shoppingCart.set(j,m);
                        shoppingCart.set(i,n);
                    }
                    if(shoppingCart.get(i).getPrice()==shoppingCart.get(j).getPrice()){
                        if(shoppingCart.get(i).getPurchaseTime()<shoppingCart.get(j).getPurchaseTime()){
                            Collections.swap(shoppingCart,i,j);
                        }
                    }
                }
            }
        }
        for(int i=0;i< shoppingCart.size();i++){
            System.out.println(shoppingCart.get(i));
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            product.getStore().transact(product,1);
            updateWallet(wallet=wallet+product.getPrice());
            shoppingCart.remove(product);
            return true;
        }else{
            return false;
        }
    }
}
