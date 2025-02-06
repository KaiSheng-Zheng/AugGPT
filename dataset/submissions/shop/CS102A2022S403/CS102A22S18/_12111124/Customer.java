import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0 ;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    private int total=0;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating))
            return true;
        else return false;
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && product.getPrice() <= wallet){
            shoppingCart.add(product);
            total++;
            wallet -= product.getPrice();
            store.transact(product,0);
            product.setStore(store);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCart1 = new ArrayList<>();
        shoppingCart1.addAll(shoppingCart);
        if(sortMethod == SortBy.PurchaseTime){
        }
        if(sortMethod == SortBy.Rating){
            for(int i = 0;i<shoppingCart1.size()-1;i++){
                for(int j = 0;j<shoppingCart1.size()-1-i;j++){
                   if(shoppingCart1.get(j).getAvgRating() > shoppingCart1.get(j+1).getAvgRating()){
                       Product a = shoppingCart1.get(j);
                       shoppingCart1.set(j,shoppingCart1.get(j+1));
                       shoppingCart1.set(j+1,a);
                   }
                   if(shoppingCart1.get(j).getAvgRating() == shoppingCart1.get(j+1).getAvgRating() && shoppingCart1.get(j).getTime() > shoppingCart1.get(j+1).getTime()){
                       Product a = shoppingCart1.get(j);
                       shoppingCart1.set(j,shoppingCart1.get(j+1));
                       shoppingCart1.set(j+1,a);
                   }
               }
           }
        }
        if(sortMethod == SortBy.Price){
            for(int i = 0;i<shoppingCart1.size();i++){
                for(int j = i+1;j<shoppingCart1.size();j++){
                    if(shoppingCart1.get(i).getPrice() > shoppingCart1.get(j).getPrice()){
                        Product a = shoppingCart1.get(i);
                        shoppingCart1.set(i,shoppingCart1.get(j));
                        shoppingCart1.set(j,a);
                    }
                    if(shoppingCart1.get(i).getPrice() == shoppingCart1.get(j).getPrice() && shoppingCart1.get(i).getTime() > shoppingCart1.get(j).getTime()){
                        Product a = shoppingCart1.get(i);
                        shoppingCart1.set(i,shoppingCart1.get(j));
                        shoppingCart1.set(j,a);
                    }
                }
            }
        }
        for(int i = 0;i<shoppingCart1.size();i++){
            System.out.println(shoppingCart1.get(i));
        }
    }
    public boolean refundProduct(Product product){
        boolean has = false;
        for(int i = 0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).getId() == product.getId())
                has = true;
        }
        if(has){
            shoppingCart.remove(product);
            product.getStore().transact(product,1);
            wallet += product.getPrice();
            return true;
        }
        else return false;
    }
}