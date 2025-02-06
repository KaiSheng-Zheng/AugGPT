import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private HashMap<Integer,Store> suyuan;

    public Customer(String name, float wallet) {
        cnt++;
        id =cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        this.suyuan = new HashMap<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            suyuan.put(product.getId(),store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] newProduct = new Product[shoppingCart.size()];
        for (int i = 0; i < shoppingCart.size(); i++) {
            newProduct[i] = shoppingCart.get(i);
        }
        switch (sortMethod) {
            case PurchaseTime: {
                for (int i = 0; i < newProduct.length; i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            }
            case Rating: {
                Arrays.sort(newProduct, new SortByRating());
                for (int i = 0; i < newProduct.length; i++) {
                    System.out.println(newProduct[i].toString());
                }break;
            }
            case Price: {
                Arrays.sort(newProduct, new SortByPrice());
                for (int i = 0; i < newProduct.length; i++) {
                    System.out.println(newProduct[i].toString());
                }break;
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (suyuan.containsKey(product.getId())) {
            Store store = suyuan.get(product.getId());
            store.transact(product,1);
            shoppingCart.remove(shoppingCart.indexOf(product));
            updateWallet(product.getPrice());
            suyuan.remove(product.getId());
            return true;
        } else {
            return false;
        }
    }

    private class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            if (p2.getAvgRating() <= p1.getAvgRating()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private class SortByPrice implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            if (p2.getPrice() <= p1.getPrice()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}