import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Integer> stores;
    private HashMap<Float, Product> ratingHashMap;
    private HashMap<Float, Product> priceHashMap;
    private HashMap<Integer, Store> storeHashMap;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        this.stores = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }


    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            stores.add(store.getID());
            this.ratingHashMap.put(product.getAvgRating(), product);
            this.priceHashMap.put(product.getPrice(), product);
            this.storeHashMap.put(product.getID(), store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime: {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
            case Rating: {
                float[] shoppingCart1 = new float[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    shoppingCart1[i] = shoppingCart.get(i).getAvgRating();
                }
                Arrays.sort(shoppingCart1);
                for (int i = 0; i < shoppingCart1.length; i++) {
                    System.out.println(ratingHashMap.get(shoppingCart1[i]));
                }
            }
            case Price: {
                float[] shoppingCart1 = new float[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    shoppingCart1[i] = shoppingCart.get(i).getPrice();
                }
                Arrays.sort(shoppingCart1);
                for (int i = 0; i < shoppingCart1.length; i++) {
                    System.out.println(priceHashMap.get(shoppingCart1[i]));
                }
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            storeHashMap.remove(product.getID());
            updateWallet(product.getPrice());
            storeHashMap.get(product.getID()).addProduct(product);
            storeHashMap.get(product.getID()).transact(product, 1);
            return true;
        } else {
            return false;
        }
    }

}
