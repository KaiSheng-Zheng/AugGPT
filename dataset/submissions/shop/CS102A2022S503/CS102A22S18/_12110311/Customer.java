import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    Map<Product, Store> History = new HashMap<Product, Store>();

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        Customer.cnt++;
        this.id = Customer.cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && product.getPrice() <= this.wallet){
            store.removeProduct(product);
            this.wallet -= product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            History.put(product,store);
            return true;
        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] shoppingCart = this.shoppingCart.toArray(new Product[0]);
        switch (sortMethod) {
            case PurchaseTime: {
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
                break;
            }
            case Price:{
                Arrays.sort(shoppingCart,(p1,p2) ->Float.compare(p1.getPrice(),p2.getPrice()) );
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
                break;
            }
            case Rating:{
                Arrays.sort(shoppingCart,(p1,p2) ->Float.compare(p1.getAvgRating(),p2.getAvgRating()) );
                for (Product product : shoppingCart) {
                    System.out.println(product);
                }
                break;
            }

        }
    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            this.wallet += product.getPrice();
            History.get(product).transact(product,1);
            History.remove(product);
            return true;
        }
        else
            return false;
    }
}
