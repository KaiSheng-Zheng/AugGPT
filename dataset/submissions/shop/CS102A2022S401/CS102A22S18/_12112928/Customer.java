import java.text.DecimalFormat;
import java.util.*;
import java.lang.Math;

public class Customer {
    private static int cnt;
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private ArrayList<Store> stores=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            store.transact(product,0);
            float p=-1*product.getPrice();
            updateWallet(p);
            shoppingCart.add(product);product.setBuytime(shoppingCart.size());product.addstores(store);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for(int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Rating){
            ArrayList<Product>k=new ArrayList<>();
            for (int i=0;i<shoppingCart.size();i++){
               k.add(shoppingCart.get(i));
            }
            Collections.sort(k,new SortByrating());
            for(int i=0;i<shoppingCart.size();i++){
                System.out.println(k.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Price){
            ArrayList<Product>k=new ArrayList<>();
            for (int i=0;i<shoppingCart.size();i++){
                k.add(shoppingCart.get(i));
            }
            Collections.sort(k,new SortByprice());
            for(int i=0;i<shoppingCart.size();i++){
                System.out.println(k.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if(product.getStores().size()!=0&&shoppingCart.contains(product)){
            if(product.getStores().get(0).getIncome()>= product.getPrice()){
                product.getStores().get(0).transact(product,1);
                shoppingCart.remove(product);
                wallet=wallet+product.getPrice();
                return true;
            }
            else return false;

        }
        else return false;
    }

}
class SortByrating implements Comparator<Product>{
    @Override
    public int compare(Product p1,Product p2){
        if(p1.getAvgRating()> p2.getAvgRating()||(p1.getAvgRating()==p2.getAvgRating())&&p1.getBuytime()>p2.getBuytime()){
            return 1;
        }
        else return -1;
    }
}
class SortByprice implements Comparator<Product>{
    @Override
    public int compare(Product p1,Product p2){
        if(p1.getPrice()> p2.getPrice()||(p1.getPrice()==p2.getPrice())&&p1.getBuytime()>p2.getBuytime()){
            return 1;
        }
        else return -1;
    }
}