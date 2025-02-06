import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
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
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            store.transact(product, 0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            seller.put(product.getId(), store);
            return true;

        }
        return false;

    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime: {
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            }
            case Rating: {
                Product [] p=new Product[shoppingCart.size()];
                for (int i=0;i<shoppingCart.size();i++){
                    p[i]=shoppingCart.get(i);

                }
                Arrays.sort(p, (o1, o2) -> o2.getAvgRating()<= o1.getAvgRating() ?1:-1);
                for (Product p2:p) {
                    System.out.println(p2);
                }
                break;

            }
            case Price: {
                Product [] p=new Product[shoppingCart.size()];
                for (int i=0;i<shoppingCart.size();i++){
                    p[i]=shoppingCart.get(i);

                }
                Arrays.sort(p, (o1, o2) -> o2.getPrice()<= o1.getPrice() ?1:-1);
                for (Product p2:p) {
                    System.out.println(p2);
                }
                break;

            }
        }
    }

    public boolean refundProduct(Product product) {
        if (seller.containsKey(product.getId())) {
            Store store = seller.get(product.getId());
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            store.transact(product, 1);
            seller.remove(product.getId());
            return true;
        }
        return false;
    }

    private HashMap<Integer, Store> seller = new HashMap<>();

}