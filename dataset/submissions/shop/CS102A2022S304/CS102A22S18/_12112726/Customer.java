import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (int num = 0; num < shoppingCart.size(); num++) {
                System.out.println(shoppingCart.get(num));
            }
        }

        if (sortMethod.equals(SortBy.Rating)) {
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating() >= o2.getAvgRating())
                        return 1;
                    else return -1;
                }
            });
            for (int num = 0; num < shoppingCart.size(); num++) {
                System.out.println(shoppingCart.get(num));
            }
        }

        if (sortMethod.equals(SortBy.Price)) {
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() >= o2.getPrice())
                        return 1;
                    else return -1;
                }
            });
        }
        for (int num = 0; num < shoppingCart.size(); num++) {
            System.out.println(shoppingCart.get(num));
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }else return false;
    }
}