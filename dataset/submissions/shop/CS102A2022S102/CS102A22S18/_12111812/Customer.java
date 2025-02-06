import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {

    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Product,Store> hashMap = new HashMap<>();

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if(rating >= 1 && rating <= 5){
            product.setRating(rating);
            return true;
        }
        else{
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            this.wallet -= product.getPrice();
            this.shoppingCart.add(product);
            store.transact(product, 0);
            hashMap.put(product, store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> products = new ArrayList<>();
        for(Product product : shoppingCart){
            products.add(product);
        }
        switch (sortMethod){
            case PurchaseTime:
                for(Product product: shoppingCart){
                    System.out.println(product);
                }
                break;
            case Price:
                products.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return new Float(o1.getPrice()).compareTo(new Float(o2.getPrice()));
                    }
                });
                for(Product product: products){
                    System.out.println(product);
                }
                break;
            case Rating:
                products.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return new Float(o1.getAvgRating()).compareTo(new Float(o2.getAvgRating()));
                    }
                });
                for(Product product: products){
                    System.out.println(product);
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        if(hashMap.containsKey(product)){
            hashMap.get(product).transact(product,1);
            shoppingCart.remove(product);
            wallet += product.getPrice();
            hashMap.remove(product);
            return true;
        }
        else
            return false;
    }
}
enum SortBy {
    PurchaseTime, Rating, Price
}
