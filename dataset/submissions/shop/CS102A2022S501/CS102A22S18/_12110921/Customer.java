import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    public HashMap<Product,Store> storeBelong=new HashMap<>();
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet > product.getPrice()){
            shoppingCart.add(product);
            storeBelong.put(product,store);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
       if (sortMethod == SortBy.PurchaseTime){
           for (Product product : shoppingCart) {
               System.out.println(product);
           }
       }
       if (sortMethod==SortBy.Rating){
           ArrayList<Product> newList=new ArrayList<>(shoppingCart);
           for (int i = 0; i < newList.size()-1; i++) {
               for (int j = 0; j < newList.size()-1-i; j++) {
                   if (newList.get(j).getAvgRating()>newList.get(j+1).getAvgRating()){
                       Collections.swap(newList,j,j+1);
                   }
               }
           }
           for (Product product : newList) {
               System.out.println(product);
           }
       }
        if (sortMethod==SortBy.Price){
            ArrayList<Product> newList=new ArrayList<>(shoppingCart);
            for (int i = 0; i < newList.size()-1; i++) {
                for (int j = 0; j < newList.size()-1-i; j++) {
                    if (newList.get(j).getPrice()>newList.get(j+1).getPrice()){
                        Collections.swap(newList,j,j+1);
                    }
                }
            }
            for (Product product : newList) {
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            storeBelong.get(product).transact(product,1);
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }
        else return false;
    }
}