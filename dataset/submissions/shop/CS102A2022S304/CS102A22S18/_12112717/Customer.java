import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private ArrayList<Store> stores = new ArrayList<>();

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean hasStore(Store store) {
        boolean p = false;
        if (!stores.isEmpty()) {
            for (Store value : stores) {
                if (value.getId() == store.getId()) {
                    p = true;
                    break;
                }
            }
        }
        return p;
    }

    public int hasStoreNumber(Product product) {
        int k = 0;
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i).getId() == product.getId()) {
                k = i;
                break;
            }
        }
        return k;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean p = false;
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            p = true;
            store.transact(product, 0);
            if (!hasStore(store)) {
                stores.add(store);
            }
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
        }
        return p;
    }


    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for (Product o : shoppingCart
            ) {
                System.out.println(o.toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating)) {
            float[] a = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                a[i] = shoppingCart.get(i).getAvgRating();
            }
            Arrays.sort(a);
            ArrayList<Product> newShoppingCart = new ArrayList<>();
            for (float v : a) {
                for (int j = 0; j < a.length; j++) {
                    if (v == shoppingCart.get(j).getAvgRating()) {
                        newShoppingCart.add(shoppingCart.get(j));
                    }
                }
            }
            for (Product o : newShoppingCart
            ) {
                System.out.println(o.toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)) {
            float[] a = new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                a[i] = shoppingCart.get(i).getPrice();
            }
            Arrays.sort(a);
            ArrayList<Product> newShoppingCart = new ArrayList<>();
            for (float v : a) {
                for (int j = 0; j < a.length; j++) {
                    if (v == shoppingCart.get(j).getPrice()) {
                        newShoppingCart.add(shoppingCart.get(j));
                    }
                }
            }
            for (Product o : newShoppingCart
            ) {
                System.out.println(o.toString());
            }
        }

    }

    public int hasShoppingCortNumber(Product product) {
        int k = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId() == product.getId()) {
                k = i;
                break;
            }
        }
        return k;
    }

    public boolean hasShoppingCort(Product product) {
        boolean p = false;
        if (!shoppingCart.isEmpty()) {
            for (Product value : shoppingCart) {
                if (value.getId() == product.getId()) {
                    p = true;
                    break;
                }
            }
        }
        return p;
    }

    public boolean removeShoppingCort(Product product) {
        boolean p = hasShoppingCort(product);
        if (p) {
            this.shoppingCart.remove(hasShoppingCortNumber(product));
        }
        return p;
    }

    public boolean refundProduct(Product product) {
        boolean p = false;
        if (removeShoppingCort(product)) {
            updateWallet(product.getPrice());
            p = true;
            for (Store store : stores) {
                int o = 0;
                for (int j = 0; j < store.getID().size(); j++) {
                    if (product.getId() == store.getID().get(j)) {
                        store.transact(product, 1);
                        o = 1;
                        break;
                    }
                }
                if (o == 1) {
                    break;
                }
            }
        }

        return p;
    }
}
