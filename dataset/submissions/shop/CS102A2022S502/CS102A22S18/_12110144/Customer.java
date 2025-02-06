import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;// will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private ArrayList<Product> rep=new ArrayList<>();
    private ArrayList<Store> res=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            updateWallet(-product.getPrice());shoppingCart.add(product);store.transact(product,0);
            rep.add(product);res.add(store);
            return true;}
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
     SortBy s=sortMethod;
     if(s==SortBy.PurchaseTime){
         for (int i = 0; i < shoppingCart.size(); i++) {
             System.out.println(shoppingCart.get(i));
         }
     }else if(s==SortBy.Price){
      ArrayList<Product> t=shoppingCart;
         Collections.sort(t,new PriceComparator());
         for (int i = 0; i < t.size(); i++) {
             System.out.println(t.get(i));
         }
     }else if(s==SortBy.Rating){
         ArrayList<Product> t=shoppingCart;
         Collections.sort(t,new RatingComparator());
         for (int i = 0; i < t.size(); i++) {
             System.out.println(t.get(i));
         }
     }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            for (int i = 0; i < rep.size(); i++) {
                if(rep.get(i).getId()==product.getId()){res.get(i).transact(product,1);}
                shoppingCart.remove(product);
            }

            return true;
        } else return false;
    }
}
class PriceComparator implements Comparator<Product> {
    public int compare(Product p1,Product p2){
        return new Float(p1.getPrice()).compareTo(p2.getPrice());
    }
}
class RatingComparator implements Comparator<Product>{
    public int compare(Product p1,Product p2){
        return new Float(p1.getAvgRating()).compareTo(p2.getAvgRating());
    }
}