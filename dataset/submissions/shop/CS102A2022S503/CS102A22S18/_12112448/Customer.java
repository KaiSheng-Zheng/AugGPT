import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name,float wallet){
        shoppingCart=new ArrayList<>();
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (wallet >= product.getPrice() && store.hasProduct(product)) {
            store.transact(product,0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
        return true;
        }
        else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.Rating){
        shoppingCart.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Float.compare(o1.getAvgRating(),o2.getAvgRating());
            }
        });}
        else if(sortMethod==SortBy.Price){
        shoppingCart.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Float.compare(o1.getPrice(),o2.getPrice());
            }
        });}
        else if(sortMethod==SortBy.PurchaseTime){
        shoppingCart.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return 0;
            }
        });}
        for(int i=0;i<shoppingCart.size();i++){
            System.out.println(shoppingCart.get(i));

        }    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());

            return true;
        }
        else{
            return false;
        }
    }
}
