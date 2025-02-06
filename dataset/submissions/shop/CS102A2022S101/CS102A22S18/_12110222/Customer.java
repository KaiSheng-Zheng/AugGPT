import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;
private HashMap<Product,Store>  hashMap=new HashMap<>();

    public Customer(String name, float wallet){

        this.name =name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }
    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&product.getPrice()<=wallet){wallet-= product.getPrice();
        store.removeProduct(product);
store.transact(product,0);
        shoppingCart.add(product);
       hashMap.put(product,store);
        return true;
        }
        else{return false;}
    }
    public void viewShoppingCart(SortBy sortMethod){
       Product[] a = this.shoppingCart.toArray(new Product[0]);
        if(sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }
        if(sortMethod==SortBy.Rating){

                Arrays.sort(a,(x,y) -> Float.compare(x.getAvgRating(),y.getAvgRating()));
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }

        }
        if(sortMethod==SortBy.Price){
            Arrays.sort(a,(x,y) -> Float.compare(x.getPrice(),y.getPrice()));
            for (int i = 0; i <a.length; i++) {
                System.out.println(a[i]);
            }
        }
    }
    public boolean refundProduct(Product product){
      if(hashMap.containsKey(product)){
     wallet+= product.getPrice();
     shoppingCart.remove(product);
       hashMap.get(product).transact(product,1);
       hashMap.remove(product);
       return true;}
      return false;
    }

}
