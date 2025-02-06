import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    HashMap<Integer, Store> getStore;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            this.getStore = new HashMap<>();
            this.getStore.put(product.getId(), store);
            return true;
        } else {
            return false;
        }
    }

    public byte compareRating(Product product1, Product product2) {
        if (product1.getAvgRating() > product2.getAvgRating()) {
            return 1;
        } else if (product1.getAvgRating() < product2.getAvgRating()) {
            return -1;
        } else {
            if (shoppingCart.indexOf(product1) > shoppingCart.indexOf(product2)) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public byte comparePrice(Product product1, Product product2) {
        if (product1.getPrice() > product2.getPrice()) {
            return 1;
        } else if (product1.getPrice() < product2.getPrice()) {
            return -1;
        } else {
            if (shoppingCart.indexOf(product1) > shoppingCart.indexOf(product2)) {
                return 1;
            } else {
                return -1;
            }
        }
    }


    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        } else if (sortMethod == SortBy.Rating) {
            Product[] cart = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                cart[i] = shoppingCart.get(i);
            }
            byte a;
            boolean rightSort;
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                rightSort = true;
                for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                    a = compareRating(cart[j], cart[j + 1]);
                    if (a == 1) {
                        rightSort = false;
                        Product larger;
                        larger = cart[j];
                        cart[j] = cart[j + 1];
                        cart[j + 1] = larger;
                    }
                }
                if (rightSort) {
                    break;
                }
            }
            for (int i = 0; i < cart.length; i++) {
                System.out.println(cart[i]);
            }
        } else if (sortMethod == SortBy.Price) {
            Product[] cart = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                cart[i] = shoppingCart.get(i);
            }
            byte a;
            boolean rightSort;
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                rightSort = true;
                for (int j = 0; j < shoppingCart.size() - 1 - i; j++) {
                    a = comparePrice(cart[j], cart[j + 1]);
                    if (a == 1) {
                        rightSort = false;
                        Product larger;
                        larger = cart[j];
                        cart[j] = cart[j + 1];
                        cart[j + 1] = larger;
                    }
                }
                if (rightSort) {
                    break;
                }
            }
        }
    }

    public boolean refundProduct(Product product) {
        byte count = 0;
        for (int i = 0; i < this.shoppingCart.size(); i++) {
            if (this.shoppingCart.get(i).equals(product)) {
                count++;
                break;
            }
        }
        if (count == 1) {
            Store thisStore = getStore.get(product.getId());
            thisStore.transact(product, 1);
            this.shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        } else {
            return false;
        }

    }
}