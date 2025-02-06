import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Integer,Store> shoppingHistory;

    public Customer(String name, float wallet){
        Customer.cnt++;
        this.name = name;
        this.id = Customer.cnt;
        this.wallet = wallet;
        this.shoppingHistory = new HashMap<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && product.getPrice()<=this.wallet){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            this.shoppingHistory.put(product.getID(),store);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        Product[] A = this.shoppingCart.toArray(new Product[0]);
        if (sortMethod == SortBy.Price){
            Arrays.sort(A,(x,y) -> Float.compare(x.getPrice(), y.getPrice()));
            for (Product product : A ){
                System.out.println(product);
            }
        }else if (sortMethod == SortBy.Rating){
            Arrays.sort(A,(x,y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
            for (Product product : A){
                System.out.println(product);
            }
        }else if (sortMethod == SortBy.PurchaseTime){
            for (Product product : A){
                System.out.println(product);
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingHistory.containsKey(product.getID())){
            Store store = shoppingHistory.get(product.getID());
            store.transact(product,1);
            shoppingCart.remove(shoppingCart.indexOf(product));
            updateWallet(product.getPrice());
            shoppingHistory.remove(product.getID());
            return true;
        }else {
            return false;
        }
    }
}