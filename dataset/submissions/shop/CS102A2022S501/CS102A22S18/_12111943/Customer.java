import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
        this.shoppingCart = new ArrayList<>();
    }

    public ArrayList<Product> getShoppingCart(){
        return this.shoppingCart;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);

    }

    public void updateWallet(float amount){
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        for(int i=0; i<store.getProductList().size(); i++){
            if(store.hasProduct(product) && this.wallet >= product.getPrice()){
                store.transact(product,0);
                this.shoppingCart.add(product);
                updateWallet(-product.getPrice());
                product.store = store;
                product.buyOrder  = shoppingCart.indexOf(product);
                return true;
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for(int i=0; i<getShoppingCart().size(); i++){
                System.out.println(getShoppingCart().get(i));
            }
        }
        else if(sortMethod == SortBy.Rating){
            getShoppingCart().sort(new Comparator<Product>() {
                @Override
                public int compare(Product product1, Product product2) {
                    if(product1.getAvgRating() > product2.getAvgRating()){
                        return 1;
                    }
                    else if(product1.getAvgRating() < product2.getAvgRating()){
                        return -1;
                    }
                    else{
                        if (product1.buyOrder > product2.buyOrder){
                            return 1;
                        }
                        else {
                            return -1;
                        }
                    }
                }
            });
            for(int i=0; i<getShoppingCart().size(); i++){
                System.out.println(getShoppingCart().get(i));
            }
        }
        else if(sortMethod == SortBy.Price){
            getShoppingCart().sort(new Comparator<Product>() {
                @Override
                public int compare(Product product1, Product product2) {
                    if(product1.getPrice() > product2.getPrice()){
                        return 1;
                    }
                    else if(product1.getPrice() < product2.getPrice()){
                        return -1;
                    }
                    else{
                        if (product1.buyOrder > product2.buyOrder){
                            return 1;
                        }
                        else {
                            return -1;
                        }
                    }
                }
            });
            for(int i=0; i<getShoppingCart().size(); i++){
                System.out.println(getShoppingCart().get(i));
            }
        }
    }

    public boolean refundProduct(Product product){
        for(int i=0; i<shoppingCart.size(); i++){
            if(shoppingCart.get(i) == product){
                product.store.transact(product,1);
                shoppingCart.remove(product);
                updateWallet(product.getPrice());
                return true;
            }
        }
        return false;
    }
}
