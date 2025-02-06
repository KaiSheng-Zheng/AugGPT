import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
//        shoppingCart.add(product);
//        if (store.getProductList().contains(product)){
//            if (wallet>=product.getPrice()){
//                store.getProductList().remove(product);
//                wallet-=product.getPrice();
//                return true;
//            }
//        }
//        return false;
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            return true;
        }
        return false;
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
    public boolean refundProduct(Product product){
        return true;
    }
}
