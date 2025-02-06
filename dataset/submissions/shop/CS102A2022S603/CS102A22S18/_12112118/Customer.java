import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }


    public boolean rateProduct(Product product, int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.removeProduct(product);
            shoppingCart.add(product);
            this.wallet = this.wallet - product.getPrice();
            store.setIncome(store.getIncome()+product.getPrice());
            product.setStore(store);
            return true;
        } else {
            return false;
        }
    }



    public void viewShoppingCart(SortBy sortMethod) {
         if (sortMethod == SortBy.PurchaseTime) {
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
         else if (sortMethod == SortBy.Rating){
             for (int j=0;j<shoppingCart.size();j++){
                 for (int i=j;i<shoppingCart.size();i++){
                     if (shoppingCart.get(j).getAvgRating()>shoppingCart.get(i).getAvgRating()){
                         Collections.swap(shoppingCart,j,i);
                     }
                 }
             }
             for(int i=0;i<shoppingCart.size();i++){

                 System.out.println(shoppingCart.get(i).toString());
             }
         }
         else if (sortMethod==SortBy.Price){
             for (int j=0;j<shoppingCart.size();j++){
                 for (int i=j;i<shoppingCart.size();i++){
                     if (shoppingCart.get(j).getPrice()>shoppingCart.get(i).getPrice()){
                         Collections.swap(shoppingCart,j,i);
                     }
                 }
             }
             for(int i=0;i<shoppingCart.size();i++){
                 System.out.println(shoppingCart.get(i).toString());
             }
         }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            this.wallet=this.wallet+product.getPrice();
            product.getStore().transact(product,1);
            return true;
        }
        else {return false;}
    }
}