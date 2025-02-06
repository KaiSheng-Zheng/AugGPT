import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private static int cnt;
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
        this.wallet = wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product) && wallet >= product.getPrice()){
            this.wallet = wallet - product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (Objects.equals(sortMethod.getNumber(), "1")){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (Objects.equals(sortMethod.getNumber(), "2")) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                    if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(i + 1).getAvgRating()) {
                        Product temp = shoppingCart.get(i);
                        shoppingCart.set(i,shoppingCart.get(i + 1));
                        shoppingCart.set(i+1,temp);
                    }
            }
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (Objects.equals(sortMethod.getNumber(), "3")) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (shoppingCart.get(i).getPrice() > shoppingCart.get(i + 1).getPrice()) {
                    Product temp = shoppingCart.get(i);
                    shoppingCart.set(i,shoppingCart.get(i + 1));
                    shoppingCart.set(i+1,temp);
                }
            } for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            return true;}
        else {return false;
        }
    }
}
