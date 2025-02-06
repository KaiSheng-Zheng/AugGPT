import java.util.*;
import java.lang.Object;
public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Product,Store> Connect=new HashMap<>();
    public Customer(String name,float wallet){
        this.name=name;
        this.id=cnt+1;
        this.wallet=wallet;
        cnt++;
    }
    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        Connect.put(product,store);
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            this.updateWallet(-1*product.getPrice());
            return true;
        }
        else{return false;}
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Price){
            ArrayList<Product> shoppingCart0=new ArrayList<>();
            shoppingCart0.addAll(shoppingCart);
            float[] prices=new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                prices[i]=shoppingCart.get(i).getPrice();
            }
            Arrays.sort(prices);
            for (int i = 0; i < prices.length; i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(j).getPrice()==prices[i]){
                        System.out.println(shoppingCart.get(j).toString());
                        shoppingCart.remove(shoppingCart.get(j));
                        break;
                    }
                }
            }
            shoppingCart.addAll(shoppingCart0);
        }
        if (sortMethod==SortBy.Rating){
            ArrayList<Product> shoppingCart0=new ArrayList<>();
            shoppingCart0.addAll(shoppingCart);
            float[] ratings=new float[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                ratings[i]=shoppingCart.get(i).getAvgRating();
            }
            Arrays.sort(ratings);
            for (int i = 0; i < ratings.length; i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(j).getAvgRating()==ratings[i]){
                        System.out.println(shoppingCart.get(j).toString());
                        shoppingCart.remove(shoppingCart.get(j));
                        break;
                    }
                }
            }
            shoppingCart.addAll(shoppingCart0);
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            this.updateWallet(product.getPrice());
            Connect.get(product).transact(product,1);
            return true;
        }
        else{return false;}
    }

}