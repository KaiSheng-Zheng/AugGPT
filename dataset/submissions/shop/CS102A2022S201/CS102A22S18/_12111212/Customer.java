import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private HashMap<Product,Store> map = new HashMap<>();

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
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
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            map.put(product,store);
            return true;
        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (Product product : shoppingCart){
                    System.out.println(product.toString());
                }
                break;
            case Rating:
                TreeMap<Float,Product> sortedMap1 = new TreeMap<>();
                for (Product product : shoppingCart){
                    sortedMap1.put(product.getAvgRating(),product);
                }
                for (Product product : sortedMap1.values()){
                    System.out.println(product.toString());
                }
                break;
            case Price:
                TreeMap<Float,Product> sortedMap2 = new TreeMap<>();
                for (Product product : shoppingCart){
                    sortedMap2.put(product.getPrice(),product);
                }
                for (Product product : sortedMap2.values()){
                    System.out.println(product.toString());
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product)){
            return false;
        }
        else {
            shoppingCart.remove(product);
            wallet += product.getPrice();
            map.get(product).transact(product,1);
            return true;
        }
    }
}