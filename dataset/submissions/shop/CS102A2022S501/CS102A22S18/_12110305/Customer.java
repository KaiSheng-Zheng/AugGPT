import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private HashMap<Product, Store> purchasedHistory = new HashMap<>();

    public Customer(String name, float wallet){
        ++cnt;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && product.getPrice() <= wallet){
            store.transact(product,0);
            updateWallet( -product.getPrice());
            this.shoppingCart.add(product);
            purchasedHistory.put(product, store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime -> {
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
            }
            case Rating -> {
                ArrayList<Product> tmp = new ArrayList<Product>();
                for (int i = 0; i < shoppingCart.size(); i++) {
                    tmp.add(i, shoppingCart.get(i));
                }
                tmp.sort((o1, o2) -> {
                    if (o1.getAvgRating() - o2.getAvgRating() < 0)
                        return -1;
                    else if (o1.getAvgRating() - o2.getAvgRating() > 0)
                        return 1;
                    return 0;
                });
                for (Product product : tmp) {
                    System.out.println(product);
                }
            }
            case Price -> {
                ArrayList<Product> tmp = new ArrayList<Product>();
                for (int i = 0; i < shoppingCart.size(); i++) {
                    tmp.add(i, shoppingCart.get(i));
                }
                tmp.sort((o1, o2) -> {
                    if (o1.getPrice() - o2.getPrice() < 0)
                        return -1;
                    else if (o1.getPrice() - o2.getPrice() > 0)
                        return 1;
                    return 0;
                });
                for (Product product : tmp) {
                    System.out.println(product);
                }
            }
        }
    }

        public boolean refundProduct(Product product){
            if(purchasedHistory.containsKey(product)){
                Store store = purchasedHistory.get(product);
                store.transact(product,1);
                shoppingCart.remove(product); updateWallet(product.getPrice());
                purchasedHistory.remove(product);
                return true;
            }
            return false;
        }

    }

