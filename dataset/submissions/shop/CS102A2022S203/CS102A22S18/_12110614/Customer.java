import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            product.setStore(store);
            shoppingCart.add(product);
            wallet = wallet - product.getPrice();
            store.transact(product, 0);
            return true;
        } else {
            return false;
        }
    }


    public void viewShoppingCart(SortBy sortMethod) {

        if (sortMethod == SortBy.PurchaseTime) {
            int a =shoppingCart.size();
            for (int i = 0; i < a; i++) {
                Product product = shoppingCart.get(i);
                System.out.println(product);
            }
        }
        if (sortMethod == SortBy.Rating) {
            shoppingCart.sort(Comparator.comparing(Product::getAvgRating));
            int a= shoppingCart.size();
            for (int i = 0; i <a; i++) {
                Product product = shoppingCart.get(i);
                System.out.println(product);
            }

        }
        if (sortMethod == SortBy.Price) {
            int a=this.shoppingCart.size();
            Product[] productCart = new Product[a];
            for (int i = 0; i < a; i++){
                productCart[i] =shoppingCart.get(i);
            }
            for (int i = 0; i <a; i++) {
                Product product = productCart[i];
                System.out.println(product);
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
            this.wallet = wallet + product.getPrice();
            product.getStore().transact(product, 1);
            return true;
        } else {
            return false;
        }
    }
}



