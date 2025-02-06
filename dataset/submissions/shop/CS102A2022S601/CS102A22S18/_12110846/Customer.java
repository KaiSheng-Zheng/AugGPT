
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
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
        if( store.hasProduct(product) && wallet >= product.getPrice() ){
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            store.removeProduct(product);
            return true;
        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> temp = new ArrayList<>(shoppingCart);

        if( sortMethod == SortBy.PurchaseTime ){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if( sortMethod == SortBy.Price ){
            for (int i = 0; i < temp.size() - 1 ; i++) {
                for (int j = i; j < temp.size() - 1 -i; j++) {
                    if( temp.get(j).getPrice() > temp.get(j+1).getPrice() ){
                        Product x = temp.get(j);
                        temp.set(j,temp.get(j+1));
                        temp.set(j+1,x);
                    }
                }
            }
            for (Product product : temp) {
                System.out.println(product.toString());
            }
        }
        if( sortMethod == SortBy.Rating ){
            for (int i = 0; i < temp.size() - 1 ; i++) {
                for (int j = i; j < temp.size() - 1 - i; j++) {
                    if( temp.get(j).getAvgRating() > temp.get(j+1).getAvgRating() ){
                        Product x = temp.get(j);
                        temp.set(j,temp.get(j+1));
                        temp.set(j+1,x);
                    }
                }
            }
            for (int i = temp.size(); i >= 0; i--) {
                System.out.println(temp.get(i).toString());
            }
        }

    }

    public boolean refundProduct(Product product){
        return true;
    }
}
