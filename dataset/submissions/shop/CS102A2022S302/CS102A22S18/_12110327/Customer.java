import java.util.ArrayList;
import java.util.Arrays;

public class Customer {

    private static int cnt = 0;
    int n = 0;

    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    private ArrayList<Product> purchasedHistory = new ArrayList<>();
    private Object[][] p = new Object[100][100];


    public Customer(String name, float wallet) {
        Customer.cnt++;
        this.id = Customer.cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {

        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            n++;
            store.transact(product, 0);
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            this.purchasedHistory.add(product);
            p[n][0] =product;
            p[n][1] =store;
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] purchaseArray = this.shoppingCart.toArray(new Product[0]);
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : purchaseArray) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Rating) {
            Arrays.sort(purchaseArray, (x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
            for (Product product : purchaseArray) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Price) {
            Arrays.sort(purchaseArray, (x, y) -> Float.compare(x.getPrice(), y.getPrice()));
            for (Product product : purchaseArray) {
                System.out.println(product);
            }
        }
    }

    public boolean refundProduct(Product product) {
        int j = 0;
        if (this.shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
            this.wallet =wallet +  product.getPrice();
            for(int i = 0; i<p.length;i++){
                if(p[i][0] == product){
                    j = i;
                    break;
                }
            }
            Store s = (Store) p[j][1];
            s.transact(product,1);
            this.purchasedHistory.remove(product);
            return true;
        }
        return false;
    }
}