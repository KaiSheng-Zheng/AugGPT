import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private  static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    private HashMap<Product,Store> history;

    public Customer(String name,float wallet){
        Customer.cnt++;
        this.id =Customer.cnt;
        this.name = name;
        this.wallet =wallet;
        this.shoppingCart = new ArrayList<>();
        this.history = new HashMap<>();
    }

    public boolean rateProduct(Product product,int rating){return product.setRating(rating);}
    public void updateWallet(float amount){ this.wallet +=amount;}
    public boolean purchaseProduct(Store store,Product product) {
        if(store.hasProduct(product) && this.wallet >= product.getPrice()){
            store.transact(product,0);
            this.shoppingCart.add(product);
            this.wallet -= product.getPrice();
            this.history.put(product,store);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        Product[] list = this.shoppingCart.toArray(new Product[0]);
        switch (sortMethod){
            case Price:
                Arrays.sort(list,(x,y)->Float.compare(x.getPrice(),y.getPrice()));
                for (Product product : list){
                    System.out.println(product);
                }
                break;
            case Rating:
                Arrays.sort(list,(x,y)->Float.compare(x.getAvgRating(),y.getAvgRating()));
                for (Product product : list){
                    System.out.println(product);
                }
                break;
            case PurchaseTime:
                for (Product product : list){
                    System.out.println(product);
                }
        }
    }

    public boolean refundProduct(Product product){
    if(this.shoppingCart.contains(product)){
        this.shoppingCart.remove(product);
        this.wallet += product.getPrice();
        this.history.get(product).transact(product,1);
        this.history.remove(product);
        return true;
    }
    return false;
    }
}
