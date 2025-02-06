import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        Customer.cnt++;
        this.id=Customer.cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&this.wallet>= product.getPrice()){
            this.shoppingCart.add(product);
            this.wallet-= product.getPrice();
            store.transact(product, 0);
            return true;}
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        Product[] way = this.shoppingCart.toArray(new Product[0]);
        if (sortMethod==SortBy.Price){
            Arrays.sort(way,(a,b)->Float.compare(a.getPrice(),b.getPrice()));
            for (Product product:way)
                System.out.println(product);
        } else if (sortMethod==SortBy.Rating) {
            Arrays.sort(way,(a,b)->Float.compare(a.getAvgRating(),b.getAvgRating()));
            for (Product product:way)
                System.out.println(product);
        }else if (sortMethod==SortBy.PurchaseTime)
            for (Product product:way)
                System.out.println();
    }
    public boolean refundProduct(Product product){
        if (this.shoppingCart.contains(product)){
            this.shoppingCart.remove(product);
            this.wallet += product.getPrice();
            return true;
        }
        return false;
    }
}
