import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
        cnt+=1;
        this.id=cnt;
        this.wallet=wallet;
        this.name=name;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&this.wallet>=product.getPrice()){
            this.wallet-= product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        List<Product> lists = new ArrayList<>(this.shoppingCart);
        if (SortBy.Rating==sortMethod){
            Collections.sort(this.shoppingCart,Product.byRate);
        }if (SortBy.Price==sortMethod){
            Collections.sort(this.shoppingCart,Product.byprice);
        }for (int i=0;i<lists.size();++i){
            System.out.println(lists.get(i).toString());
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            this.wallet+=product.getPrice();
            return true;
        }else return false;
    }
}