import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)) {
            return true;
        }
        else
            return false;
    }
    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            this.shoppingCart.add(product);
            this.wallet = this.wallet - product.getPrice();
            return true;
        }else
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        Product[] Array =this.shoppingCart.toArray(new Product[0]);
        if (sortMethod == SortBy.PurchaseTime){
            for (Product product:Array){
                System.out.println(product);
            }
        }
        if (sortMethod == SortBy.Rating) {
        Arrays.sort(Array, (x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
            for (Product product : Array) {
                System.out.println(product);
            }
        }
        if (sortMethod==SortBy.Price){
            Arrays.sort(Array, (x, y) -> Float.compare(x.getPrice(), y.getPrice()));
            for (Product product : Array) {
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
}