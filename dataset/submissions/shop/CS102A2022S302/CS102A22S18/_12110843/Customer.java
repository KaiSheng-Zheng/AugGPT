import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private HashMap<Product, Store> purchase = new HashMap<>();

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
        wallet += amount;
    }


    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            this.purchase.put(product,store);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.transact(product, 0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product>shopping=new ArrayList<>(shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod == SortBy.Rating) {
            shopping.sort(new SortByRating());
            for (int i = 0; i < shopping.size(); i++) {
                System.out.println(shopping.get(i).toString());
            }
        }else if (sortMethod == SortBy.Price) {
            shopping.sort(new SortByPrice());
            for (int i = 0; i < shopping.size(); i++) {
                System.out.println(shopping.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+= product.getPrice();
            this.purchase.get(product).transact(product,1);
            this.purchase.remove(product);
            return true;
        }else {
            return false;
        }
    }
    class SortByPrice implements Comparator<Product>{

        @Override
        public int compare(Product o1, Product o2) {
            return Float.compare(o1.getPrice(),o2.getPrice());
        }
    }
    class SortByRating implements Comparator<Product>{

        @Override
        public int compare(Product o1, Product o2) {
            return Float.compare(o1.getAvgRating(),o2.getAvgRating());
        }
    }
}
