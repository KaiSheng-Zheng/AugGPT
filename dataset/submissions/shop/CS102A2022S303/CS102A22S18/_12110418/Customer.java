import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    HashMap<Product,Store> findStores=new HashMap<>();
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&this.wallet>=product.getPrice()){
            store.transact(product,0);
            this.shoppingCart.add(product);
            this.updateWallet(-product.getPrice());
            findStores.put(product,store);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod== SortBy.PurchaseTime){
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
        if (sortMethod== SortBy.Rating){
            ArrayList<Product> rating = new ArrayList<>(this.shoppingCart);
            for (int i = 0; i < rating.size(); i++) {
                for (int j =i+1; j <rating.size(); j++) {
                    if (rating.get(j).getAvgRating()<rating.get(i).getAvgRating()) {
                        Product a=rating.get(j);
                        rating.set(j,rating.get(i));
                        rating.set(i,a);
                    }
                }
            }
            for (Product product : rating) {
                System.out.println(product);
            }
        }
        if (sortMethod==SortBy.Price){
            ArrayList<Product> rating = new ArrayList<>(this.shoppingCart);
            for (int i = 0; i < rating.size(); i++) {
                for (int j =i+1; j <rating.size(); j++) {
                    if (rating.get(j).getPrice()<rating.get(i).getPrice()) {
                        Product a=rating.get(j);
                        rating.set(j,rating.get(i));
                        rating.set(i,a);
                    }
                }
            }
            for (Product product : rating) {
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        if (this.shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            this.shoppingCart.remove(product);
            findStores.get(product).transact(product,1);
            return true;
        }
       else return false;
    }

    public float getWallet() {
        return wallet;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }
}