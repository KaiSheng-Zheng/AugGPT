
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
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
    public void setName(String name){this.name=name;}
    public String getName(){return name;}
    public boolean rateProduct(Product product, int rating){
        return  (product.setRating(rating));
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&product.getPrice()<=wallet){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        }
        else {return false;}
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (Product i:shoppingCart){
                    System.out.println(i);
                }
                break;
            case Rating:
                Collections.sort(shoppingCart,(a,b)->{
                    return a.getAvgRating()-b.getAvgRating()>0?1:((b.getAvgRating()==a.getAvgRating())?0:-1);
                });
                for (Product i:shoppingCart){
                    System.out.println(i);
                }
                break;
            case Price:
                Collections.sort(shoppingCart,(a,b)->{
                    return a.getPrice()-b.getPrice()>0?1:((b.getPrice()==a.getPrice())?0:-1);
                });
                for (Product i:shoppingCart){
                    System.out.println(i);
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            product.getStore().transact(product,1);
            return true;
        }
        else {return false;}
    }
}

