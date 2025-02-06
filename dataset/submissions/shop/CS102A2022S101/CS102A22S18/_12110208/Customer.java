
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Product,Store> AK47 = new HashMap<>();
    public Customer(){}
    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }
    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }
    public void updateWallet(float amount) {
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            if(!AK47.containsKey(product)){
                this.AK47.put(product,store);
            }
            this.shoppingCart.add(product);
            store.transact(product,0);
            updateWallet(-product.getPrice());
         return true;
        }else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (Product s : shoppingCart) {
                    System.out.println(s);
                }
                break;
            case Rating:
                this.shoppingCart.sort(Comparator.comparingDouble(Product::getAvgRating));
                for (Product s : shoppingCart) {
                    System.out.println(s);
                }

                break;
            case Price:
                this.shoppingCart.sort(Comparator.comparingDouble(Product::getPrice));
                for (Product s : shoppingCart) {
                    System.out.println(s);
                }
                break;
            default:
                break;
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)) {
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            AK47.get(product).transact(product, 1);
            return true;
        }else{
            return false;
        }
    }
}
