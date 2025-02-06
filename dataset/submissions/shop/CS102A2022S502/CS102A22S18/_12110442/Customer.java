import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = Customer.cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    private HashMap<Product, Store> sequence = new HashMap<>();

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= this.wallet){
            store.transact(product,0);
            this.shoppingCart.add(product);
            this.sequence.put(product,store);
            updateWallet(-product.getPrice());
            return true;
        } else {return false;}
    }

    private class SortByRating implements Comparator<Product> {
        public int compare(Product a,Product b){
            if (b.getAvgRating()<= a.getAvgRating()){
                return 1;
            } else {return -1;}
        }
    }

    private class SortByPrice implements Comparator<Product> {
        public int compare(Product a,Product b){
            if (b.getPrice()<= a.getPrice()){
                return 1;
            } else {return -1;}
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product[] pro=new Product[this.shoppingCart.size()];
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.println(this.shoppingCart.get(i).toString());
            }
        } else if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                pro[i] = this.shoppingCart.get(i);
            }
            Arrays.sort(pro, new SortByRating());
            for (int i = 0; i < pro.length; i++) System.out.println(pro[i].toString());
        } else if (sortMethod == SortBy.Price) {
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                pro[i] = this.shoppingCart.get(i);
            }
            Arrays.sort(pro, new SortByPrice());
            for (int i = 0; i < pro.length; i++) System.out.println(pro[i].toString());
        }
    }

    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)){
            Store store = this.sequence.get(product);
            store.transact(product,1);
            updateWallet(product.getPrice());
            this.shoppingCart.remove(product);
            this.sequence.remove(product);
            return true;
        } else {return false;}
    }

}
