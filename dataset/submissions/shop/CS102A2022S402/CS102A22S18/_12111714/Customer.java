import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if(rating<=5&&rating>=1){
            product.setRating(rating);
        }
        return rating<=5&&rating>=1;
    }

    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&this.wallet>=product.getPrice()){
            store.transact(product,0);
            this.shoppingCart.add(product);
            this.updateWallet(-product.getPrice());
            product.setLatestStore(store);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean refundProduct(Product product){
        if(this.shoppingCart.size() == 0){
            return false;
        }
        else if(this.shoppingCart.contains(product)&&
               !product.getLatestStore().getProductList().contains(product)){
           this.shoppingCart.remove(product);
           this.updateWallet(product.getPrice());
           product.getLatestStore().transact(product,1);
           return true;
       }
       else{
           return false;
       }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for (Product product : this.shoppingCart) {
                System.out.println(product);
            }
        }
        if(sortMethod == SortBy.Price){
            ArrayList<Product> input = new ArrayList<>(this.shoppingCart);
            input.sort(Comparator.comparing(Product::getPrice));
            for(Product product:input){
                System.out.println(product);
            }
        }
        if(sortMethod == SortBy.Rating){
            ArrayList<Product> input = new ArrayList<>(this.shoppingCart);
            input.sort(Comparator.comparing(Product::getAvgRating));
            for(Product product:input){
                System.out.println(product);
            }
        }
    }
}
