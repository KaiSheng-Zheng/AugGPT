import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private Map<Product, Store> purchaseStore;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        this.purchaseStore = new HashMap<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating < 1 | rating > 5)
            return false;
        else {
            product.setRating(rating);
            return true;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) & wallet >= product.getPrice()) {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product, 0);
            purchaseStore.put(product, store);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime)
            for (int i = 0; i < shoppingCart.size(); i++)
                System.out.println(shoppingCart.get(i).toString());
        if (sortMethod == SortBy.Rating) {
            Product[] products = this.shoppingCart.toArray(new Product[0]);
            Product m;
            for (int i = 0; i < products.length-1; i++)
                for (int j = 0; j < products.length - 1; j++)
                    if (products[j].getAvgRating() > products[j + 1].getAvgRating()) {
                        m =products[j];
                        products[j]=products[j+1];
                        products[j+1]=m;
                    }
            for (int i =0;i<products.length;i++)
                System.out.println(products[i].toString());
        }
        if (sortMethod == SortBy.Price) {
            Product[] products = this.shoppingCart.toArray(new Product[0]);
            Product m;
            for (int i = 0; i < products.length; i++)
                for (int j = 0; j < products.length - 1; j++)
                    if (products[j].getPrice() > products[j + 1].getPrice()) {
                        m =products[j+1];
                        products[j+1]=products[j];
                        products[j]=m;
                    }
            for (int i =0;i<products.length;i++)
                System.out.println(products[i].toString());
        }

    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            purchaseStore.get(product).transact(product, 1);
            return true;
        }
        return false;
    }
}