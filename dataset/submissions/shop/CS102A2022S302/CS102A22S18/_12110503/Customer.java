import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private Map<Product,Store> productStoreMap;
    public Customer(String name, float wallet){
        id=++cnt;
        this.name=name;
        this.wallet=wallet;
        shoppingCart=new ArrayList<>();
        productStoreMap=new HashMap<>();
    }
    public boolean rateProduct(Product product, int rating){
        return (product.setRating(rating));
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            updateWallet(-product.getPrice());
            store.transact(product,0);
            shoppingCart.add(product);
            this.productStoreMap.put(product,store);
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for (Product i:shoppingCart) {
                System.out.println(i.toString());
            }
        }else if (sortMethod==SortBy.Rating){
            int j;
            ArrayList<Product> viewByRating = new ArrayList<>(shoppingCart);
            for (int l = 0; l < shoppingCart.size(); l++) {
                j=0;
                for (int i = 0; i < viewByRating.size(); i++) {
                    if (viewByRating.get(i).getAvgRating() < viewByRating.get(j).getAvgRating()) j = i;
                }
                System.out.println(viewByRating.get(j).toString());
                viewByRating.remove(viewByRating.get(j));
            }
        }else {
            int j;
            ArrayList<Product> viewByPrice = new ArrayList<>(shoppingCart);
            for (int l = 0; l < shoppingCart.size(); l++) {
                j=0;
                for (int i = 0; i < viewByPrice.size(); i++) {
                    if (viewByPrice.get(i).getPrice() < viewByPrice.get(j).getPrice()) j = i;
                }
                System.out.println(viewByPrice.get(j).toString());
                viewByPrice.remove(viewByPrice.get(j));
            }
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            this.wallet+=product.getPrice();
            this.shoppingCart.remove(product);
            this.productStoreMap.get(product).transact(product,1);
            return true;
            }
        return false;
    }
}
