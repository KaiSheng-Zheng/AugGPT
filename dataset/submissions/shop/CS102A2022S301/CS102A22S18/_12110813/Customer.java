
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Product,Store> hashMap=new HashMap<Product,Store>();
    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product)&&wallet>=product.getPrice()){
           store.transact(product,0);
            wallet=wallet- product.getPrice();
            shoppingCart.add(product);
            hashMap.put(product,store);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        for (int i = 0; i < shoppingCart.size(); i++) {
            shoppingCart.get(i).setOrder(i);
        }
        if(sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }else if(sortMethod==SortBy.Rating){
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i+1; j < shoppingCart.size(); j++) {
                    if(shoppingCart.get(i).getAvgRating()>shoppingCart.get(j).getAvgRating()){
                        Collections.swap(shoppingCart,i,j);
                    }
                    if(shoppingCart.get(i).getAvgRating()==shoppingCart.get(j).getAvgRating()){
                        if(shoppingCart.get(i).getOrder()>shoppingCart.get(j).getOrder()){
                            Collections.swap(shoppingCart,i,j);
                        }
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }else {
            for (int i = 0; i < shoppingCart.size(); i++) {
            for (int j = i+1; j < shoppingCart.size(); j++) {
                if(shoppingCart.get(i).getPrice()>shoppingCart.get(j).getPrice()){
                    Collections.swap(shoppingCart,i,j);
                }
                if(shoppingCart.get(i).getPrice()==shoppingCart.get(j).getPrice()){
                    if(shoppingCart.get(i).getOrder()>shoppingCart.get(j).getOrder()){
                        Collections.swap(shoppingCart,i,j);
                    }
                }
            }
        }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet=wallet+product.getPrice();
            hashMap.get(product).addProduct(product);
            hashMap.get(product).setIncome(hashMap.get(product).getIncome()-product.getPrice());
            return true;
        }else {
            return false;
        }
    }
}
