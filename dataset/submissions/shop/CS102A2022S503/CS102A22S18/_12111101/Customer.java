import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private  HashMap<Integer,Store> refund;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
        this.shoppingCart = new ArrayList<>();
        this.refund = new HashMap<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if( store.hasProduct(product) && wallet >= product.getPrice()){
            updateWallet(-1*product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            refund.put(product.getId(),store);
            return true;
        }else{
            return  false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if(sortMethod == SortBy.Rating){
            ArrayList<Product> shoppingcarttemp = new ArrayList<>(shoppingCart);
            shoppingcarttemp.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getAvgRating()<o2.getAvgRating()){
                        return -1;
                    } else{
                        return 1;
                    }
                }
            });
            for (Product product : shoppingcarttemp) {
                System.out.println(product.toString());
            }
        }
        if(sortMethod == SortBy. Price){
            ArrayList<Product> shoppingcarttemp = new ArrayList<>(shoppingCart);
            shoppingcarttemp.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getPrice()<o2.getPrice()){
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
            for (Product product : shoppingcarttemp) {
                System.out.println(product.toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        if(refund.containsKey(product.getId())){
            wallet = wallet + product.getPrice();
            shoppingCart.remove(product);
            refund.get(product.getId()).transact(product,1);
            refund.remove(product.getId());
            return  true;
        }
        return  false;
    }
}
