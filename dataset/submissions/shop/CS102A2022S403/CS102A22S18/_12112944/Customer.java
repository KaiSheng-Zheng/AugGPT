import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        this.id = cnt + 1;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
        this.wallet = wallet;
        cnt++;
    }

    public boolean rateProduct(Product product, int rating) {
        if (!product.setRating(rating)) {
            return false;
        } else
            return true;
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            updateWallet((product.getPrice()) * (-1));
            return true;
        } else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] products =  this.shoppingCart.toArray(new Product[]{});
        for (int i = 0; i < shoppingCart.size() - 1; i++) {
            for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                if (sortMethod == SortBy.Price) {
                    if (products[j].getPrice() > products[j + 1].getPrice()) {
                        Product temp = products[j];
                        products[j] = products[j + 1];
                        products[j + 1] = temp;
                    }
                } else if (sortMethod == SortBy.Rating) {
                    if (products[j].getAvgRating() > products[j + 1].getAvgRating()) {
                        Product temp = products[j];
                        products[j] = products[j + 1];
                        products[j + 1] = temp;
                    }
                }
            }
        }
        for(int i=0;i<products.length;i++){
            System.out.println(products[i].toString());
        }
    }
    public  boolean refundProduct(Product product){
        return true;
    }
}