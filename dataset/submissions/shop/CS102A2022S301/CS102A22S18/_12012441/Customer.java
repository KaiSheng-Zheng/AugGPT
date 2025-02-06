import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if(product.setRating(rating)){
            return true;
        }else{
            return false;
        }
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && product.getPrice()<=this.wallet){
            this.shoppingCart.add(product);
            updateWallet(product.getPrice()*(-1));
            store.transact(product,0);
            return true;
        }else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> copy=new ArrayList<>();
        for (Product product : this.shoppingCart) {
            copy.add(product);
        }
        switch (sortMethod){
            case PurchaseTime:
                for(int i=0;i<copy.size();i++){
                    System.out.println(copy.get(i));
                }
                break;
            case Rating:
                for(int i=0;i<copy.size()-1;i++){
                    for(int j=0;j<copy.size()-1-i;j++){
                        if(copy.get(j).getAvgRating()>copy.get(j+1).getAvgRating()){
                            Collections.swap(copy,j,j+1);
                        }
                    }
                }
                for(int i=0;i<copy.size();i++){
                    System.out.println(copy.get(i));
                }
                break;
            case Price:
                for(int i=0;i<copy.size()-1;i++){
                    for(int j=0;j<copy.size()-1-i;j++){
                        if(copy.get(j).getPrice()>copy.get(j+1).getPrice()){
                            Collections.swap(copy,j,j+1);
                        }
                    }
                }
                for(int i=0;i<copy.size();i++){
                    System.out.println(copy.get(i));
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
}
