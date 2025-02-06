import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Integer, Store> storeHashMap = new HashMap<>();

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        } else return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean flag = true;
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            store.transact(product, 0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            storeHashMap.put(product.getId(), store);
        }else return false;
        return flag;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod == SortBy.Price) {
            for (int i = 0, j = 1; i < shoppingCart.size() - 1; i++, j++) {
                if (shoppingCart.get(j).getPrice() < shoppingCart.get(i).getPrice()) {
                    Collections.swap(shoppingCart, i, j);
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            for (int i = 0, j = 1; i < shoppingCart.size() - 1; i++, j++) {
                if (shoppingCart.get(j).getAvgRating() < shoppingCart.get(i).getAvgRating()) {
                    Collections.swap(shoppingCart, i, j);
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        boolean flag =true;
        if (storeHashMap.containsKey(product.getId())) {
            Store store = storeHashMap.get(product.getId());
            store.transact(product, 1);
            shoppingCart.remove(shoppingCart.indexOf(product));
            updateWallet(product.getPrice());
            storeHashMap.remove(product.getId());
        }else flag=false;
        return flag;
    }
}