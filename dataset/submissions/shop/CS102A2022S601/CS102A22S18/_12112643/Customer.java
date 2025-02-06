import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Product,Integer> proIdMap = new HashMap<Product,Integer>();
    private HashMap<Product,Store> proStoreMap = new HashMap<>();
    private int proPurId = 0;
    public Customer(String name, float wallet){
        this.wallet = wallet;
        this.name = name;
        cnt++;
        this.id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
            return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet = this.wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            this.wallet = this.wallet - product.getPrice();
            shoppingCart.add(product);
            proPurId++;
            proIdMap.put(product,proPurId);
            proStoreMap.put(product,store);
            store.transact(product,0);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                Collections.sort(shoppingCart, new Comparator<Product>() {
                    @Override
                    public int compare(Product object1, Product object2) {
                        if (object1.getAvgRating() > object2.getAvgRating()) {
                            return 1;
                        } else if (object1.getAvgRating() == object2.getAvgRating()) {
                            if (proIdMap.get(object1) < proIdMap.get(object2)) {
                                return -1;
                            } else if (proIdMap.get(object1) > proIdMap.get(object2))
                                return 1;
                        } else {
                            return -1;
                        }
                        return 0;
                    }
                });
                for (int i = 0; i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            case Price:
                Collections.sort(shoppingCart, new Comparator<Product>() {
                    @Override
                    public int compare(Product object1, Product object2) {
                        if (object1.getPrice() > object2.getPrice()) {
                            return 1;
                        } else if (object1.getPrice() == object2.getPrice()) {
                            if (proIdMap.get(object1) < proIdMap.get(object2)) {
                                return -1;
                            } else if (proIdMap.get(object1) > proIdMap.get(object2))
                                return 1;
                        } else {
                            return -1;
                        }
                        return 0;
                    }
                });
                for (int i = 0; i<shoppingCart.size(); i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        boolean b = shoppingCart.contains(product);
        if (b){
            shoppingCart.remove(product);
            this.wallet = this.wallet + product.getPrice();
            proStoreMap.get(product).transact(product,1);
            return true;
        }else {
            return false;
        }
    }
}