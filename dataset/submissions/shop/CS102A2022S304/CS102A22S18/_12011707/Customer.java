import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt+=1;
        this.id =cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        boolean a=false;
        for (int i = 0; i < store.getProductList().size(); i++) {
            if(Product.equals(product,store.getProductList().get(i))){
                if(this.wallet>=product.getPrice()){
                    a=true;
                    updateWallet(-product.getPrice());
                    shoppingCart.add(product);
                }
            }
        }
        return a;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n",shoppingCart.get(i).getId(),shoppingCart.get(i).getName(),shoppingCart.get(i).getAvgRating());
            }
        }
        if(sortMethod==SortBy.Price){
            int[] x=new int[shoppingCart.size()];
            ArrayList<Float> prices=new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                prices.add(shoppingCart.get(i).getPrice());
            }
            Collections.sort(prices);
            for (int i = 0; i < prices.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if(shoppingCart.get(j).getPrice()==prices.get(prices.size()-1-i)&&x[j]==0){
                        System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n",shoppingCart.get(j).getId(),shoppingCart.get(j).getName(),shoppingCart.get(j).getAvgRating());
                        x[j]=1;
                    }
                }
            }
        }
        if(sortMethod==SortBy.Rating){
            int[] x=new int[shoppingCart.size()];
            ArrayList<Float> ratinges=new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                ratinges.add(shoppingCart.get(i).getPrice());
            }
            Collections.sort(ratinges);
            for (int i = 0; i < ratinges.size(); i++) {
                for (int j = 0; j < shoppingCart.size(); j++) {
                    if(shoppingCart.get(j).getPrice()==ratinges.get(ratinges.size()-1-i)&&x[j]==0){
                        System.out.printf("Product ID %d, %s, RMB %.2f, Rating %.1f\n",shoppingCart.get(j).getId(),shoppingCart.get(j).getName(),shoppingCart.get(j).getAvgRating());
                        x[j]=1;
                    }
                }
            }
        }
    }
}
