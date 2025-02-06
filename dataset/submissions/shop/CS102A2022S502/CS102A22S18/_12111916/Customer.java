
import java.util.ArrayList;

import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> storess;
    private ArrayList<Product> pro;
    public Customer(String name, float wallet){
        this.name=name; this.wallet=wallet;
        cnt++;
        this.id=cnt;
        this.shoppingCart=new ArrayList<>();
        this.storess=new ArrayList<Store>();
        this.pro=new ArrayList<Product>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet>=product.getPrice()){
          this.wallet-= product.getPrice();
            this.shoppingCart.add(product);
            store.removeProduct(product);
            float b=store.getIncome()+ product.getPrice();
            store.setIncome(b);
           storess.add(store);
           pro.add(product);
            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
   if(sortMethod.equals(SortBy.PurchaseTime)) {
       for (Product product : this.shoppingCart) {
           System.out.println(product.toString());
       }
        }else if(sortMethod.equals(SortBy.Rating)){
       this.shoppingCart.sort(new Comparator<Product>() {
           public int compare(Product o1, Product o2) {
               return (int) (o1.getAvgRating() - o2.getAvgRating());
           }
       });
       for (Product product : this.shoppingCart) {
           System.out.println(product.toString());
       }
   }else{
       this.shoppingCart.sort(new Comparator<Product>() {
           public int compare(Product o1, Product o2) {
               return (int) (o1.getPrice() - o2.getPrice());
           }
       });
       for (Product product : this.shoppingCart) {
           System.out.println(product.toString());
       }
   }
       }
    public boolean refundProduct(Product product) {
            boolean m = false;
            int o=0;
            int l = 0;
        for (Product value : shoppingCart) {
            if (value.equals(product)) {
                o++;
                m = true;
            }
        }
            if (m){
                int j = 0;
                for (; j < pro.size(); j++) {
                    if (pro.get(j).getName().equals(product.getName())){
                        break;
                    }
                }
                if(o>=0){
                    shoppingCart.remove(product);  wallet += product.getPrice();
                }
                storess.get(j).transact(product,1);
                return true;
            } else{
                return false;
            }
        }

    }




