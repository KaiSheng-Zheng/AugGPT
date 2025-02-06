import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private ArrayList<Product> price=new ArrayList<>();
    private float wallet;
    private HashMap<Product,Store>purchased=new HashMap<>();

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        Customer.cnt++;
        this.id=Customer.cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        }
        return false;
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product,0);
            shoppingCart.add(product);
            wallet=wallet-product.getPrice();
            purchased.put(product,store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] shop=this.shoppingCart.toArray(new Product[0]);

        if(sortMethod==SortBy.PurchaseTime){
            for (Product p:shop) {
                System.out.println(p);
            }
        }
       else if(sortMethod==SortBy.Price){
            Arrays.sort(shop,(a,b)->Float.compare(a.getPrice(),b.getPrice()));
            for (Product p:shop) {
                System.out.println(p);
            }
        }
       else if(sortMethod==SortBy.Rating){
            Arrays.sort(shop,(a,b)->Float.compare(a.getAvgRating(),b.getAvgRating()));
            for (Product p:shop) {
                System.out.println(p);
            }
        }
    }

    public boolean refundProduct(Product product) {
        if(shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            purchased.get(product).transact(product,1);
            updateWallet(product.getPrice());
            return true;
        }
        else return false;
    }
}
