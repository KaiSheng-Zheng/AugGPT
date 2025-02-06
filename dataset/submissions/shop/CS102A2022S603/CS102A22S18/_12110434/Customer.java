import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private int id;
    private String name;
    private static int cnt=0;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Product, Store> purchaseFrom=new HashMap<>();

    public Customer(String name,float wallet){
        Customer.cnt++;
        this.name=name;
        this.wallet=wallet;
        this.id = Customer.cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            this.purchaseFrom.put(product, store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] tempArray = this.shoppingCart.toArray(new Product[0]);
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : tempArray) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Rating) {
            Arrays.sort(tempArray, (x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
            for (Product product : tempArray) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Price) {
            Arrays.sort(tempArray, (x, y) -> Float.compare(x.getPrice(), y.getPrice()));
            for (Product product : tempArray) {
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        if(this.shoppingCart.contains(product)){
            this.shoppingCart.remove(product);
            this.wallet+=product.getPrice();
            this.purchaseFrom.get(product).transact(product,1);
            this.purchaseFrom.remove(product);
            return true;
        }
        return false;
    }
}
