import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Customer{
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        Customer.cnt = Customer.cnt + 1;
        this.id = Customer.cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }
    private HashMap<Product, Store> purchased = new HashMap<>();
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && this.wallet >= product.getPrice()){
            this.purchased.put(product, store);
            store.transact(product,0);
            this.shoppingCart.add(product);
            this.wallet = this.wallet - product.getPrice();
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        Product[] array = this.shoppingCart.toArray(new Product[0]);
        if(sortMethod == SortBy.Rating){
            Arrays.sort(array, (x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));  //from internet
            for(Product product : array){
                System.out.println(product);
            }
        }
        if(sortMethod == SortBy.PurchaseTime){
            for(Product product : array){
                System.out.println(product);
            }
        }if(sortMethod == SortBy.Price){
            Arrays.sort(array, (x, y) -> Float.compare(x.getPrice(), y.getPrice()));      //from internet
            for(Product product : array){
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        if(this.shoppingCart.contains(product)){
            this.purchased.get(product).transact(product,1);
            this.purchased.remove(product);
            this.shoppingCart.remove(product);
            this.wallet = this.wallet + product.getPrice();
            return true;
        }
        return false;
    }
}
