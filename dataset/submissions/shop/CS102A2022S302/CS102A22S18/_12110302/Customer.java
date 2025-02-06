import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Integer,Store> purchaseFrom=new HashMap<>();

    public Customer(String name, float wallet){
        cnt++;
        this.name=name;
        this.wallet=wallet;
        this.id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }
        else return false;
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            purchaseFrom.put(product.getId(),store);
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] products = this.shoppingCart.toArray(new Product[0]);
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : products) {
                System.out.println(product);
            }
        }
        else if (sortMethod == SortBy.Price) {
            Arrays.sort(products, (x, y) -> Float.compare(x.getPrice(), y.getPrice()));
            for (Product product : products) {
                System.out.println(product);
            }
        }
        else if (sortMethod == SortBy.Rating) {
            Arrays.sort(products, (x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public boolean refundProduct(Product product){
        if (purchaseFrom.containsKey(product.getId())){
            Store store=purchaseFrom.get(product.getId());
            store.transact(product,1);
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            purchaseFrom.remove(product.getId());
            return true;
        }
        else return false;
    }
}