import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;  //let cnt be a number that reflects id
    private int id; // unique
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Product, Store> history = new HashMap<>();

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
    }

//methods
//rate
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)==true){
            return true;
        }
        else{
            return false;
        }
    }
//update
    public void updateWallet(float amount){
        wallet+=amount;
    }
//if can purchase
    public boolean purchaseProduct(Store store, Product product){
        if(wallet>= product.getPrice()&&store.hasProduct(product)){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            history.put(product,store);
            return true;
        }
        else{
            return false;
        }
    }
//view Shoppingcart
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if(sortMethod==SortBy.Rating){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    while (o1.getAvgRating()!=o2.getAvgRating())
                    {return (int) (o1.getAvgRating()-o2.getAvgRating());}
                    return 0;
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if(sortMethod==SortBy.Price){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice()-o2.getPrice());
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if(history.containsKey(product)){
            this.shoppingCart.remove(product);
            Store from=history.get(product);
            history.remove(product);
            from.transact(product,1);
            updateWallet(product.getPrice());
            return true;
        }
        else{return false;}
    }
}
