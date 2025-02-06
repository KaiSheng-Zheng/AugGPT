import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if((store.hasProduct(product)) && (wallet >= product.getPrice())){
            store.transact(product,0);
            shoppingCart.add(product);
            wallet -= product.getPrice();
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> newCart = new ArrayList<Product>(shoppingCart);
        switch (sortMethod){
            case PurchaseTime: {
                for (Product product : newCart) {
                    System.out.println(product.toString());
                }
                break;
            }
            case Rating: {
                newCart.sort(new SortByRating());
                for (Product product : newCart) {
                    System.out.println(product.toString());
                }
                break;
            }
            case Price: {
                newCart.sort(new SortByPrice());
                for (Product product : newCart) {
                    System.out.println(product.toString());
                }
                break;
            }
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
}
class SortByRating implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getAvgRating() >= o2.getAvgRating()){
            return 2;
        }else {
            return -2;
        }
    }
}
class SortByPrice implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getPrice() >= o2.getPrice()){
            return 2;
        }else {
            return -2;
        }
    }
}