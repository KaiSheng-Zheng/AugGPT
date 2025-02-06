import java.lang.reflect.Array;
import java.util.*;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();
    private float wallet;
    public Customer(String name,float wallet){
        cnt++;
        this.id=cnt;
        this.wallet=wallet;
        this.name=name;
    }
    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }else return false;
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        if(store.hasProduct(product) && this.wallet>= product.getPrice()){
            updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            store.transact(product,0);
            product.setLocation(store);
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        final ArrayList<Product> re=new ArrayList<>(this.shoppingCart);
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<re.size();i++){
                System.out.printf("%s"+System.lineSeparator(),re.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Price){
            ArrayList<Product> p=SortBy.Price.Price(this.shoppingCart);
            for (int i=0;i<p.size();i++){
                System.out.printf("%s"+System.lineSeparator(),p.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Rating){
            ArrayList<Product> r=SortBy.Rating.Rating(this.shoppingCart);
            for (int i=0;i<r.size();i++){
                System.out.printf("%s"+System.lineSeparator(),r.get(i).toString());
            }
        }
        this.shoppingCart=re;
    }
    public boolean refundProduct(Product product){
        if(hasProduct(product)){
            this.wallet+=product.getPrice();
            this.shoppingCart.remove(product);
            product.getLocation().transact(product,1);
            return true;
        }else return false;
    }
    public boolean hasProduct(Product product){
        int r=0;
        try {
            for (Product product1 : this.shoppingCart) {
                if (product1.getId()==product.getId()){
                    r++;
                }
            }
            if (r==0){
                return false;
            }else return true;
        }catch (Exception e){
            return false;
        }
    }
}
