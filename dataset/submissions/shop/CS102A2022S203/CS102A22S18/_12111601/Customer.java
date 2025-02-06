import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    static int shoppingTime=0;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;this.wallet=wallet;
        id=++cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(!store.hasProduct(product))return false;
        if(wallet>=product.getPrice()){
            store.transact(product,0);
            wallet-=product.getPrice();
            product.shoppingTime=++shoppingTime;
            product.boughtFrom=store;
            shoppingCart.add(product);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
//            shoppingCart.sort((o1, o2) -> o1.shoppingTime-o2.shoppingTime);
            for(Product p:shoppingCart)System.out.println(p);
        }
        else if(sortMethod== SortBy.Rating){
            shoppingCart.sort((o1, o2) -> {
                if(o1.getAvgRating()-o2.getAvgRating()!=0)return (int)Math.signum(o1.getAvgRating()-o2.getAvgRating());
                else return o1.shoppingTime- o2.shoppingTime;
            });
            for(Product p:shoppingCart)System.out.println(p);
        }
        else if(sortMethod==SortBy.Price){
            shoppingCart.sort((o1, o2) -> {
                if(o1.getPrice()-o2.getPrice()!=0)return (int)Math.signum(o1.getPrice()-o2.getPrice());
                else return o1.shoppingTime-o2.shoppingTime;

            });
            for(Product p:shoppingCart)System.out.println(p);
        }
    }
    boolean checkShoppingCart(Product product){
        for(Product p:shoppingCart){
            if(p.equals(product))return true;
        }
        return false;
    }
    public boolean refundProduct(Product product){
        if(product.boughtFrom==null||(!checkShoppingCart(product)))return false;
        product.boughtFrom.transact(product,1);
        shoppingCart.remove(product);wallet+=product.getPrice();
        return true;
    }
}
enum SortBy {
    PurchaseTime, Rating, Price
}