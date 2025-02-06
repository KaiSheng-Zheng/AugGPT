import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private static HashMap tips = new HashMap<>();
    public Customer(String name,float wallet){
        cnt=cnt+1;
        id=cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if (1 <= rating && rating <= 5) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        if(store.hasProduct(product) && product.getPrice() <= wallet){
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            store.transact(product, 0);
            tips.put(product.getId(), store);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.Rating){
            ArrayList<Product> agency = new ArrayList<>(shoppingCart);
            agency.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getAvgRating() > o2.getAvgRating() ? 1 : -1;
                }
            });
            for (Product i : agency) {
                System.out.println(i.toString());
            }

        }
        if(sortMethod==SortBy.Price){
            ArrayList<Product> agency = new ArrayList<>(shoppingCart);
            agency.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getPrice() > o2.getPrice() ? 1 : -1;
                }
            });
            for (Product i : agency) {
                System.out.println(i.toString());
            }

        }
        if(sortMethod==SortBy.PurchaseTime){
            for (Product i : shoppingCart) {
                System.out.println(i.toString());
            }
        }


    }
    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            Store store = (Store) tips.get(product.getId());
            store.transact(product, 0);
            wallet += product.getPrice();
            shoppingCart.remove(product);
            return true;
        } else {return false;}
    }
    
}
enum SortBy{
    PurchaseTime,Rating,Price
}
