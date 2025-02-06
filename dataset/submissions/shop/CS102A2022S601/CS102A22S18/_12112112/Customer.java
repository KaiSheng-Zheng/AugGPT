import java.util.ArrayList;
import java.util.*;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt= cnt+1;
        this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
       if (rating>=1 && rating<=5){
           ArrayList<Integer> a=product.getRatings();
           a.add(rating);
           product.setRatings(a);

           return true;
       }else {
           return false;
       }
    }
    public void updateWallet(float amount){
        this.wallet=this.wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (this.wallet>=product.getPrice() && store.hasProduct(product)){
            this.shoppingCart.add(product);
            this.wallet=this.wallet-product.getPrice();
            store.removeProduct(product);
            store.setIncome(store.getIncome()+product.getPrice());
            product.storeid=store;
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size() ; i++) {
                System.out.println(shoppingCart.get(i).toString());
            }

        } else if (sortMethod == SortBy.Rating) {

            for (int i = 0; i < shoppingCart.size()-1 ; i++) {
                for (int j = i; j < shoppingCart.size() ; j++) {

                if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating()) {
                    Collections.swap(shoppingCart, i, j);
                }
            }}
            for (int i = 0; i < shoppingCart.size() ; i++) {
                System.out.println(shoppingCart.get(i).toString());
            }

        } else if (sortMethod == SortBy.Price) {
            for (int i = 0; i < shoppingCart.size()-1 ; i++) {
                for (int j = i; j < shoppingCart.size() ; j++) {

                    if (shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice()) {
                        Collections.swap(shoppingCart, i, j);
                    }
                }}
            for (int i = 0; i < shoppingCart.size() ; i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }


    public boolean refundProduct(Product product){
        for (int i = 0; i < shoppingCart.size() ; i++) {
            if (shoppingCart.get(i)==product){
                shoppingCart.remove(product);
                this.wallet=this.wallet+product.getPrice();
                Store store =product.storeid;
                store.addProduct(product);
                store.setIncome(store.getIncome()-product.getPrice());
                return true;
            }
        }

return false;
    }
}
