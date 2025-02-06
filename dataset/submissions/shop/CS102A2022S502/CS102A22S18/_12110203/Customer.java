import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart= new ArrayList<>();;
    private float wallet;

    public Customer(String name,float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&(this.wallet>=product.getPrice())){
            store.transact(product, 0);
            shoppingCart.add(product);
            wallet-=product.getPrice();
            purchasedRecord.put(product, store);
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        Product[] vsc = this.shoppingCart.toArray(new Product[0]);
        if (sortMethod == SortBy.PurchaseTime){
            for (Product product : vsc) {
                System.out.println(product);
            }
        }else if (sortMethod == SortBy.Rating){
            Arrays.sort(vsc, (x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
            for (Product product : vsc){
                System.out.println(product);
            }
        }else if (sortMethod == SortBy.Price){
            Arrays.sort(vsc, (x, y) -> Float.compare(x.getPrice(), y.getPrice()));
            for (Product product : vsc){
                System.out.println(product);
            }
        }
    }
    private HashMap<Product, Store> purchasedRecord = new HashMap<>();;
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            purchasedRecord.get(product).transact(product, 1);
            purchasedRecord.remove(product);
            return true;
        }
        return false;
    }
}