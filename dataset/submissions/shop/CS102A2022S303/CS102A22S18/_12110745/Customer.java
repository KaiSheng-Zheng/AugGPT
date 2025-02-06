import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {

    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products;default is empty.
    private float wallet;
    HashMap<Product,Store> Sites = new HashMap<Product, Store>();

    public Customer(String name, float wallet){
        cnt++;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }else{
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet>=product.getPrice()){
            product.store = store;
            Sites.put(product,store);
            shoppingCart.add(product); updateWallet(-product.getPrice());
            store.transact(product,0);
            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }else if (sortMethod == SortBy.Rating){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating() - o2.getAvgRating()>=0){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }else if (sortMethod == SortBy.Price){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice() - o2.getPrice()>0){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            product.store.transact(product,1);
            updateWallet(product.getPrice());
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Customer alice = new Customer("Alice", 20000);
        Store store = new Store("store1");
        Product laptop = new Product("laptop",10000);
        Product Table = new Product("table",300);
        Product Mouse = new Product("Mouse",100);
        laptop.setRating(3);Table.setRating(3);Mouse.setRating(4);
        store.addProduct(laptop);store.addProduct(Table);store.addProduct(Mouse);
        alice.purchaseProduct(store, laptop);
        alice.purchaseProduct(store, Table);
        alice.purchaseProduct(store, Mouse);
        alice.viewShoppingCart(SortBy.Rating);
    }
}
enum SortBy {
    PurchaseTime, Rating, Price
}

