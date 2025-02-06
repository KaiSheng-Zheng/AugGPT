import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(0);
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt ++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }else {
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product i : shoppingCart) {
                System.out.println(i.toString());
            }
        } else {
            ArrayList<Product> cart = shoppingCart;
            if (sortMethod == SortBy.Price) {
                Collections.sort(cart, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() > o2.getPrice()) {
                            return 1;
                        } else if (o1.getPrice() < o2.getPrice()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
                for (Product i : cart) {
                    System.out.println(i.toString());
                }
            } else {
                Collections.sort(cart, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.GetAvgRating() > o2.GetAvgRating()) {
                            return 1;
                        } else if (o1.GetAvgRating() < o2.GetAvgRating()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
                for (Product i : cart) {
                    System.out.println(i.toString());
                }
            }
        }
    }
    public boolean refundProduct(Product product){
        return true;
        }
}