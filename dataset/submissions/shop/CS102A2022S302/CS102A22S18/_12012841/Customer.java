import java.util.ArrayList;
public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;


    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
        id = cnt;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        boolean a = product.setRating(rating);
        return a;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;

    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) &&( wallet - product.getPrice() >= 0)) {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            product.setStore(store);
            return true;
        } else {

            return false;
        }

    }


    public void viewShoppingCart(SortBy sortMethod) {
        System.out.println(shoppingCart);
    }

    public boolean refundProduct(Product product) {
   if(shoppingCart.contains(product)){
       product.getStore().transact(product,1);
       this.shoppingCart.remove(product);
       this.wallet+=product.getPrice();
       return true;

   }else {
       return false;
   }

   }
    }