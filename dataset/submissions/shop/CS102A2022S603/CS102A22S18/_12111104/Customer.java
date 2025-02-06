import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    HashMap<Product, Store> find = new HashMap<Product, Store>();

    public Customer(String name, float wallet) {
        cnt = cnt + 1;
        this.name = name;
        this.id = cnt;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            find.put(product, store);
            store.transact(product,0);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.getM() == 1) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod.getM() == 2) {
            float[] y = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                y[i] = (shoppingCart.get(i).getAvgRating());
            }
            Arrays.sort(y);
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (i < shoppingCart.size() - 1 && y[i] == y[i + 1]) {
                    continue;
                }
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(j).getAvgRating() == y[i]) {
                        System.out.println(shoppingCart.get(j).toString());
                    }
                }
            }
        } else {
            float[] x = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                x[i] = (shoppingCart.get(i).getPrice());
            }
            Arrays.sort(x);
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (i < shoppingCart.size() - 1 && x[i] == x[i + 1]) {
                    continue;
                }
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(j).getPrice() == x[i]) {
                        System.out.println(shoppingCart.get(j).toString());
                    }
                }
            }
        }
//        shoppingCart.sort(new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return 0;
//            }
//        });
    }

    public boolean hasProduct(Product product) {
        for (Product value : shoppingCart) {
            if (value.getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean refundProduct(Product product) {
        if (hasProduct(product)) {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            find.get(product).transact(product,1);
            return true;
        } else {
            return false;
        }
    }
}