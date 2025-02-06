import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;


    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
         if (1<=rating&&rating<=5){
             product.setRating(rating);
             return true;
         }else {
             return false;
         }
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            wallet-=product.getPrice();
             product.setProductFrom(store);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shoppingCart1=new ArrayList<>(shoppingCart);
        int n=shoppingCart1.size();
        if (n==0){
            return;
        }
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart1.size(); i++) {
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            for (int i=0;i<shoppingCart1.size();i++){
                for (int k=i;k<shoppingCart1.size();k++){
                    if (shoppingCart1.get(i).getAvgRating()>shoppingCart1.get(k).getAvgRating()){
                        Collections.swap(shoppingCart1,i,k);

                    }
                }
            }
            for (int i=0;i<shoppingCart1.size()-1;i++){
                if (shoppingCart1.get(i).getAvgRating()==shoppingCart1.get(i+1).getAvgRating()&&shoppingCart1.get(i).getId()>shoppingCart1.get(i+1).getId()){
                    Collections.swap(shoppingCart1,i,i+1);
                }
            }
            for (int i = 0; i < shoppingCart1.size(); i++) {
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Price){
            for (int i=0;i<shoppingCart1.size();i++){
                for (int k=i;k<shoppingCart1.size();k++){
                    if (shoppingCart1.get(i).getPrice()>shoppingCart1.get(k).getPrice()){
                        Collections.swap(shoppingCart1,i,k);
                    }
                }
            }
            for (int i=0;i<shoppingCart1.size()-1;i++){
                if (shoppingCart1.get(i).getPrice()==shoppingCart1.get(i+1).getPrice()&&shoppingCart1.get(i).getId()>shoppingCart1.get(i+1).getId()){
                    Collections.swap(shoppingCart1,i,i+1);
                }
            }
            for (int i = 0; i < shoppingCart1.size(); i++) {
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        int ji=0;
        for (int i=0;i<shoppingCart.size();i++){
            if (shoppingCart.get(i).getId()==product.getId()){
                ji++;
            }
        }
        if (ji==0){
            return false;
        }else {
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            product.getProductFrom().transact(product,1);
            return true;
        }
    }
}
