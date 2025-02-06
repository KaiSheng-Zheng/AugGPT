import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating<1||rating>5)return false;
        else {
            product.setRating(rating);
            return true;
        }
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        product.ls = store;
        if (store.hasProduct(product) &&product.getPrice()<=this.wallet){
            store.transact(product,0);
            updateWallet((-1)*product.getPrice());
            this.shoppingCart.add(product);
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Price){
           Collections.sort(shoppingCart, new Comparator<Product>() {
               @Override
               public int compare(Product o1, Product o2) {
                   if (o1.getPrice() < o2.getPrice()) return -1;
                   else return 1;
               }
           });
           for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
           }
        }
        if (sortMethod==SortBy.Rating){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating() < o2.getAvgRating()) return -1;
                    else return 1;
                }
            });
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }

    }

    public boolean refundProduct(Product product){
        int a = 0;
        for (int i=0;i<shoppingCart.size();i++){
            if (product.getId()==shoppingCart.get(i).getId())
                a++;
        }
        if (a!=0){
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            product.ls.transact(product,1);
            return true;
        }
        else return false;
    }
}