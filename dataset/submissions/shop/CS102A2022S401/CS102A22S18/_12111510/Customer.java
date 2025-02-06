import java.util.ArrayList;
import java.util.Collections;
public class Customer {

    private static int cnt = 0 ;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt += 1;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating < 1 || rating >5){
            return false;
        }
        product.setRating(rating);
        return true;

    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            product.setWhichStore(store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCart1 = shoppingCart;
        if(sortMethod==SortBy.Rating){
            for (int j = 0; j <shoppingCart.size() - 1 ; j++) {
                Product min = shoppingCart.get(j);
                for (int i = 0; i < shoppingCart.size(); i++) {
                    if (shoppingCart1.get(i).getAvgRating() > min.getAvgRating()) {
                        Collections.swap(shoppingCart1, i, j);
                    }else if (shoppingCart1.get(i).getAvgRating() == min.getAvgRating()){
                        if (shoppingCart1.get(i).getId() > min.getId()){
                            Collections.swap(shoppingCart1, i, j);
                        }
                    }
                }
            }
        }
        if(sortMethod==SortBy.PurchaseTime){
            shoppingCart1 = shoppingCart;
        }
        if (sortMethod==SortBy.Price){
            for (int j = 0; j <shoppingCart.size() - 1 ; j++) {
                Product min = shoppingCart.get(j);
                for (int i = 0; i < shoppingCart.size(); i++) {
                    if (shoppingCart1.get(i).getPrice() > min.getPrice()) {
                        Collections.swap(shoppingCart1, i, j);
                    }else if (shoppingCart1.get(i).getPrice() == min.getPrice()){
                        if (shoppingCart1.get(i).getId() > min.getId()){
                            Collections.swap(shoppingCart1, i, j);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart1.get(i).toString());
        }
    }

    public boolean refundProduct(Product product){
        if (hasProduct1(product)){
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            product.getWhichStore().transact(product,1);
            
        }else {
            return false;
        }
        return true;
    }

    public boolean hasProduct1(Product product){
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i)==product){
                return true;
            }
        }
        return false;
    }



}

