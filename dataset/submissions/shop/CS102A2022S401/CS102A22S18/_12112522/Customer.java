import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name,float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            product.from(store);
            store.transact(product,0);
            return true;
        }else{
            return false;
        }

    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }else if(sortMethod.equals(SortBy.Rating)){
            ArrayList<Product> pro = shoppingCart;
            Collections.sort(pro, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getAvgRating()<o2.getAvgRating()) {
                        return -1;
                    }else if(o1.getAvgRating()==o2.getAvgRating()) {
                        return 0;
                    }else{
                        return 1;
                }}});
            for (Product product : pro) {
                System.out.println(product.toString());
            }
        }else if(sortMethod.equals(SortBy.Price)){
            ArrayList<Product> pro = shoppingCart;
            Collections.sort(pro, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getPrice()<o2.getPrice()){
                        return -1;
                    }else if(o1.getPrice()==o2.getPrice()){
                        return 0;
                    }else{
                        return 1;
                    }
                }
            });
            for (Product product : pro) {
                System.out.println(product.toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            Store store=product.store;
            store.transact(product,1);
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            return true;
    }else{
            return false;
        }
    }
}
