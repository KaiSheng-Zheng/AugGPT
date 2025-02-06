import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private float wallet;
    private ArrayList<Product> shoppingCart;
    private HashMap<Integer, Store> map2;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
        map2 = new HashMap<Integer, Store>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            shoppingCart.add(product);
            wallet -= product.getPrice();
            map2.put(product.getId(), store);
            return true;
        } else return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        long s = shoppingCart.size();
        Product[] Pro = new Product[(int) s];
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < s; i++) {
                String a = shoppingCart.get(i).toString();
                System.out.println(a);
            }
        } else {
            for (int i = 0; i < s; i++) {
                Pro[i] = shoppingCart.get(i);
            }
            if (sortMethod == SortBy.Rating) {
                Arrays.sort(Pro, new SortByRating());
                for (int i = 0; i < Pro.length; i++) {
                    String b = Pro[i].toString();
                    System.out.println(b);
                }
            }
            if (sortMethod == SortBy.Price) {
                Arrays.sort(Pro, new SortByPrice());
                for (int i = 0; i < Pro.length; i++) {
                    String b = Pro[i].toString();
                    System.out.println(b);
                }
            }
        }
    }
    public boolean refundProduct(Product product) {
        if (map2.containsKey(product.getId())) {
            map2.get(product.getId()).transact(product, 1);
            shoppingCart.remove(shoppingCart.indexOf(product));
            wallet += product.getPrice();
            map2.remove(product.getId());
            return true;
        } else return false;
    }
}
    class SortByPrice implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.getPrice() - o2.getPrice());
        }
    }
    class SortByRating implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.getAvgRating() - o2.getAvgRating());
        }
    }