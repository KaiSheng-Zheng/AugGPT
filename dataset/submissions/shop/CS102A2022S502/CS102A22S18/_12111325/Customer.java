import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList <Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.name = name ;
        this.wallet = wallet ;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating) ;
    }

    public void updateWallet(float amount){
        this.wallet = wallet + amount ;
    }

    public boolean purchaseProduct(Store store, Product product){
        boolean j = false ;
        if(store.hasProduct(product) ){
            if(wallet >= product.getPrice() ){
                shoppingCart.add(product) ;
                wallet = wallet - product.getPrice() ;
                store.transact(product, 0) ;
                product.setStore(store) ;
                j = true ;
            }
        }
        return j;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.getType() == 2){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int  compare(Product o1, Product o2) {
                    return Float.compare(o1.getAvgRating() , o2.getAvgRating()) ;
                }
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
        else if(sortMethod.getType() == 3){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return Float.compare(o1.getPrice() , o2.getPrice()) ;
                }
            }) ;
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i) );
            }
        }
        else{
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i) );
            }
        }
    }

    public boolean refundProduct(Product product){
        boolean j = false;
        if(shoppingCart.contains(product) ){
            shoppingCart.remove(product) ;
            updateWallet(product.getPrice()) ;
            product.getStore().transact(product,1 ) ;
            j = true;
        }
        return j;
    }
}




enum SortBy {
    PurchaseTime(1),
    Rating(2),
    Price(3);

    private final int type;

    private SortBy (int type){
        this.type = type ;
    }

    public int getType() {
        return type;
    }

}