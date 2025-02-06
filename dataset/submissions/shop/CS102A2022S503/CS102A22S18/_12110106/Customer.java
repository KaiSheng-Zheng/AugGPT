import java.util.HashMap;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
public class Customer {
    private static int cnt=0;
    // initialized to 0, and will increase by 1 when the constructor is called.
private int id;
private String name;
private ArrayList<Product> shoppingCart = new ArrayList<>();
// The list of purchased products; default is empty.
private float wallet;

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        Customer.cnt++;
        this.id=Customer.cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet=wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)){
            if(wallet >= product.getPrice()){
                wallet=wallet-product.getPrice();
                store.transact(product,0);
                shoppingCart.add(product);
                return true;
            }else return false;
        }else return false;
    }


    private HashMap<Product,Store> reWrite = new HashMap<>();


    public void viewShoppingCart(SortBy sortMethod){
        Product[] allProduct = new Product[shoppingCart.size()];
        shoppingCart.toArray(allProduct);
if(sortMethod==SortBy.PurchaseTime){
for(int i=0; i<shoppingCart.size() ; i++){
    System.out.println(allProduct[i]);
}
}

else if(sortMethod==SortBy.Price){
Arrays.sort(allProduct,(a,b)->Float.compare(a.getPrice(), b.getPrice()));
    for(int i=0; i<shoppingCart.size() ; i++){
        System.out.println(allProduct[i]);
    }
}

else if(sortMethod==SortBy.Rating){
    Arrays.sort(allProduct,(a,b)->Float.compare(a.getAvgRating(), b.getAvgRating()));
    for(int i=0; i<shoppingCart.size() ; i++){
        System.out.println(allProduct[i]);
    }
}
    }
}
