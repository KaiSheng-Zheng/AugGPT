import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
public class Customer {
    private static int cnt = 0;
    private int id = 0;
    private String name = "";
    private ArrayList<Product> shoppingCart = new ArrayList<>(0);
    private HashMap<Product,Store> beenBuy = new HashMap<>(0);
    private float wallet = 0;
    public Customer(String name, float wallet){
        cnt += 1;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }
        return false;
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) & wallet >= product.getPrice()){
            store.removeProduct(product);
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            beenBuy.put(product,store);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
       switch (sortMethod){
           case PurchaseTime:
               for (Product a : shoppingCart){
                   System.out.println(a.toString());
               }
               break;
           case Price:

               shoppingCart.sort(new Comparator<Product>() {
                   @Override
                   public int compare(Product o1, Product o2) {
                       if (o1.getPrice() > o2.getPrice()) {return 1;}
                       return -1;
                   }
               });
               for (Product a : shoppingCart){
                   System.out.println(a.toString());
               }
               break;
           case Rating:
               shoppingCart.sort(new Comparator<Product>() {
                   @Override
                   public int compare(Product o1, Product o2) {
                       if (o1.getAvgRating() > o2.getAvgRating()) {return 1;}
                       return -1;
                   }
               });
               for (Product a : shoppingCart){
                   System.out.println(a.toString());
               }
               break;
       }
    }
    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product)){
            return false;
        }
        shoppingCart.remove(product);
        updateWallet(product.getPrice());
        beenBuy.get(product).addProduct(product);
        return true;
  }
}