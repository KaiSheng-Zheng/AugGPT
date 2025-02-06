import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        Customer.cnt++;
        this.id=Customer.cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating) {
        if(rating>=1&&rating<=5){
            return product.setRating(rating);
        }else{
            return false;
        }
    }
    public void updateWallet(float amount) {
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            return true;
        } else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        Product[] tempArray = this.shoppingCart.toArray(new Product[0]);
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : tempArray) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Rating) {
            Arrays.sort(tempArray, (x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
            for (Product product : tempArray) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Price) {
            Arrays.sort(tempArray, (x, y) -> Float.compare(x.getPrice(), y.getPrice()));
            for (Product product : tempArray) {
                System.out.println(product);
            }
        }
    }

}

