import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    private HashMap<Integer, Store>match =new HashMap<>();

    public Customer(String name, float wallet){
        Customer.cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }else {
            return false;
        }
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&this.wallet>= product.getPrice()){
            store.transact(product,0);
            this.wallet-= product.getPrice();
            this.shoppingCart.add(product);
            this.match.put(product.getId(),store);//hashmap chachong
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        Product[]shoppingcart=this.shoppingCart.toArray(new Product[0]);
        switch (sortMethod){
            case Rating:{
            Arrays.sort(shoppingcart,(x,y)->Float.compare(x.getAvgRating(), y.getAvgRating()));
               for (Product product:shoppingcart){
                System.out.println(product);
            }break;
        }
            case Price:{
            Arrays.sort(shoppingcart,(x,y)->Float.compare(x.getPrice(), y.getPrice()));
               for (Product product:shoppingcart){
                System.out.println(product);
            }break;
        }
            case  PurchaseTime:{
               for (Product product:shoppingcart){
                System.out.println(product);
            }break;
        }
    }
    }

    public boolean refundProduct(Product product){
        if (this.shoppingCart.contains(product)){
            shoppingCart.remove(shoppingCart.indexOf(product));
            updateWallet(product.getPrice());
            Store store1=match.get(product.getId());
           store1.transact(product,1);
           this.match.remove(product.getId());
           return true;
        }else {
            return false;//chachong
        }
    }
}
