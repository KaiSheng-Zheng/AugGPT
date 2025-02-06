import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    static HashMap<Float, Product> Rating = new HashMap<Float, Product>();
    static HashMap<Float, Product> Prices = new HashMap<Float, Product>();

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt ++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && this.wallet >= product.getPrice()){
            store.transact(product, 0);
            product.setStore(store);
            this.wallet -= product.getPrice();
            this.shoppingCart.add(product);
            Rating.put(product.getAvgRating(), product);
            Prices.put(product.getPrice(), product);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime :
                for (int i = 0; i < this.shoppingCart.size(); i++) {
                    System.out.println(this.shoppingCart.get(i).toString());
                }
                break;

            case Rating:
                Set set = Rating.keySet();
                Object[] arr = set.toArray();
                Arrays.sort(arr);
                for(Object key:arr){
                    System.out.println(Rating.get(key).toString());
                }
                break;

            case Price:
                Set set1 = Rating.keySet();
                Object[] arr1 = set1.toArray();
                Arrays.sort(arr1);
                for(Object key:arr1){
                    System.out.println(Rating.get(key).toString());
                }
                break;


        }
    }

    public boolean refundProduct(Product product){
        if (this.shoppingCart.contains(product)){
            this.shoppingCart.remove(product);
            this.updateWallet(product.getPrice());
            product.getStore().transact(product, 1);
            return true;
        }else {
            return false;
        }
    }
}
