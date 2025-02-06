import java.util.*;
import java.io.*;
import java.math.*;
//import Product;

public class Customer{ 
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Integer,Store> purchaseFrom;

    public Customer(String name, float wallet){
      this.name = name; this.wallet = wallet; this.id = ++cnt; this.shoppingCart = new ArrayList<Product>();
      this.purchaseFrom =  new HashMap<Integer, Store>();
    }
    public boolean rateProduct(Product product, int rating){
      if(product.setRating(rating) == true) return true;
      else return false;
    }
    public void updateWallet(float amount){
      this.wallet += amount;
    }
    
    public boolean refundProduct(Product product){
         if(purchaseFrom.containsKey(product.getID())){
              Store store=purchaseFrom.get(product.getID());
              store.transact(product,1);
              this.shoppingCart.remove(shoppingCart.indexOf(product));
              updateWallet(product.getPrice());
              this.purchaseFrom.remove(product.getID());
              return true;
          }
          return false;
    }
    public boolean purchaseProduct(Store store, Product product){
      if(store.hasProduct(product) && product.getPrice()  <= wallet){
        this.wallet -= product.getPrice();
        this.shoppingCart.add(product);
        store.transact(product,0);
        this.purchaseFrom.put(product.getID(),store);
        return true;
      }
      else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
       if(sortMethod == SortBy.PurchaseTime){
        for(int i = 0; i < shoppingCart.size(); i ++){
          Product now = shoppingCart.get(i);
          System.out.println(now.toString());
        }
       }
       if(sortMethod == SortBy.Rating){
        Collections.sort(shoppingCart, new  Comparator<Product>(){ 
            @Override
            public int compare(Product o1, Product o2) {
                return (o2.getAvgRating()-o1.getAvgRating() <= 0) ? 1 : -1;
            }
        });
        for(int i = 0; i < shoppingCart.size(); i ++){
          Product now = shoppingCart.get(i);
          System.out.println(now.toString());
        }
       }
       if(sortMethod == SortBy.Price){
        Collections.sort(shoppingCart, new  Comparator<Product>(){ 
            @Override
            public int compare(Product o1, Product o2) {
                return (o2.getPrice()-o1.getPrice() <= 0) ? 1 : -1;
            }
        });
        for(int i = 0; i < shoppingCart.size(); i ++){
          Product now = shoppingCart.get(i);
          System.out.println(now.toString());
        }
       }
    }
    public  static void main(String[] args){
          Customer c = new Customer("C1", 100);


    }
}

