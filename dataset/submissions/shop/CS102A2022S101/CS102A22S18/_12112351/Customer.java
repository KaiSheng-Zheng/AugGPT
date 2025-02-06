import java.util.ArrayList;
import java.util.Collections;
public class Customer {
    private static int cnt = 0 ;
    private int id;
    private String name ;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet ;

    public Customer(String name, float wallet) {
        this.name = name ;
        this.wallet = wallet ;
        Customer.cnt++ ;
        this.id = Customer.cnt ;
    }
    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating) ;
    }
    public void updateWallet(float amount) {
        this.wallet += amount ;
    }
    public boolean purchaseProduct(Store store, Product product) { //wrong
        if (store.hasProduct(product) == true & this.wallet >= product.getPrice()) {
            shoppingCart.add(product);
            this.wallet -= product.getPrice() ;
            store.transact(product, 0);
            return true ;
        } else {
            return false ;
        }
    }
    public void viewShoppingCart(SortBy sortMethod) { //wrong
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Rating) {
            Collections.sort(shoppingCart,(a1, a2) -> Float.compare(a1.getAvgRating(), a2.getAvgRating()));
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Price) {
            Collections.sort(shoppingCart,(a1, a2) -> Float.compare(a1.getPrice(), a2.getPrice()));
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
    }


    public boolean refundProduct(Product product) { //wrong
        if (shoppingCart.contains(product)) {
            this.wallet += product.getPrice();
            shoppingCart.remove(product);

            return true ;
        } else {
            return false ;
        }
    }

}
