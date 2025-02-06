import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private ArrayList<Store> s = new ArrayList<>();
    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        } else {
            product.setRating(rating);
            return true;
        }
    }
    public void updateWallet(float amount) {
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        boolean a = false;
        for (int i = 0; i < store.getProductList().size(); i++) {
            if (store.getProductList().get(i).getId() == product.getId()) {
                a = true;
                break;
            }
        }
        if (a && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            s.add(store);
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            return true;
        } else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i));
        }
        } else if (sortMethod == SortBy.Rating) {
            float[] r = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                r[i] = shoppingCart.get(i).getAvgRating();
            }
            Arrays.sort(r);
            ArrayList c = new ArrayList<>();
            ArrayList<Product> cart = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                cart.add(shoppingCart.get(i));
            }
            for (int i = 0; i < r.length; i++) {
                for (int j = 0; j < cart.size(); j++) {
                    if (cart.get(j).getAvgRating() == r[i]) {
                        c.add(cart.get(j));
                        cart.remove(j);
                    }
                }
            }
            for (int i = 0; i < c.size(); i++) {
                System.out.println(c.get(i));
            }
        } else if (sortMethod == SortBy.Price) {
            float[] p = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                p[i] = shoppingCart.get(i).getPrice();
            }
            Arrays.sort(p);
            ArrayList cc = new ArrayList<>();
            ArrayList<Product> cart1 = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                cart1.add(shoppingCart.get(i));
            }
            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < cart1.size(); j++) {
                    if (cart1.get(j).getPrice() == p[i]) {
                        cc.add(cart1.get(j));
                        cart1.remove(j);
                    }
                }
            }
            for (int i = 0; i < cc.size(); i++) {
                System.out.println(cc.get(i));
            }
        }
    }
    public boolean refundProduct(Product product) {
        boolean c = false;
        int n = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i) == product) {
                n = i;
                c = true;
                break;
            }
        }
        if (c) {
            shoppingCart.remove(n);
            updateWallet(product.getPrice());
            s.get(n).transact(product, 1);
            s.remove(n);
            return true;
        } else {
            return false;
        }
    }
}
