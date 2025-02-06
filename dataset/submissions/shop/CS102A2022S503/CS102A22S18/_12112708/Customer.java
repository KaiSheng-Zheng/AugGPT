import java.util.ArrayList;
import java.util.Arrays;

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
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet>=product.getPrice()){
            shoppingCart.add(product);
            wallet-=product.getPrice();
            store.transact(product,0);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod==SortBy.Price) {
            float[] price=new float[shoppingCart.size()];
            for (int i=0;i<shoppingCart.size();i++){
                price[i]=shoppingCart.get(i).getPrice();}
                Arrays.sort(price);
            for (int j=0;j<shoppingCart.size();j++){
                for (int k=0;k<shoppingCart.size();k++) {
                    if (j==0&&price[j]==shoppingCart.get(k).getPrice()){
                        System.out.println(shoppingCart.get(k));}
                    if (j>=1&&price[j]!=price[j-1]&&price[j] == shoppingCart.get(k).getPrice()) {
                        System.out.println(shoppingCart.get(k));
                    }
                }
            }
        }

        if (sortMethod==SortBy.Rating){
            float[] rating=new float[shoppingCart.size()];
            for (int i=0;i<shoppingCart.size();i++){
                rating[i]=shoppingCart.get(i).getAvgRating();}
            Arrays.sort(rating);
            for (int j=0;j<shoppingCart.size();j++){
                for (int k=0;k<shoppingCart.size();k++) {
                    if (j==0&&rating[j]==shoppingCart.get(k).getAvgRating()){
                        System.out.println(shoppingCart.get(k));
                    }
                    if (j>=1&&rating[j]!=rating[j-1]&&rating[j] == shoppingCart.get(k).getAvgRating()) {
                        System.out.println(shoppingCart.get(k));}
                }
            }
        }
    }
    public boolean refundProduct(Product product){
        return false;
    }

}