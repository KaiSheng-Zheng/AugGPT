import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name,float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt+=1;
        this.id=cnt;
    }
    public boolean rateProduct(Product product,int rating){

        if(rating>5||rating<1){
            return false;
        }else
            product.getRatings().add(rating);
            return true;
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        product.store=store;
        product.time+=1;
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
            wallet-= product.getPrice();
            shoppingCart.add(product);
           store.transact(product,0);
            return true;
        }else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
if(sortMethod.equals(SortBy.Price)){
           Collections.sort(shoppingCart, new Comparator<Product>() {
               @Override
               public int compare(Product o1, Product o2) {
                   if(o1.getPrice()>o2.getPrice()){
                       return 1;
                   }if(o1.getPrice()==o2.getPrice()){
                       if(o1.time>o2.time)
                           return 1;
                       else
                           return -1;
                   }else{
                       return -1;
                   }
               }
           });
for (Product product:shoppingCart){
            System.out.println(product.toString());

        }}else if(sortMethod.equals(SortBy.Rating)){
    Collections.sort(shoppingCart, new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            if(o1.getAvgRating()>o2.getAvgRating()){
                return 1;
            }if(o1.getAvgRating()==o2.getAvgRating()){
             if(o1.time>o2.time)
                return 1;
             else
                 return -1;
            }else{
                return -1;
            }
        }
    });
    for (Product product:shoppingCart){
        System.out.println(product.toString());
    }
}else if(sortMethod.equals(SortBy.PurchaseTime)){
    for (Product product:shoppingCart){
        System.out.println(product.toString());
    }
}
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+= product.getPrice();
            product.store.transact(product,1);
               return true;
        }else
            return false;
    }
}
