import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;
    private float wallet;
    private Store store;
    public Customer(String name,float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        this.store=store;
        if(store.hasProduct(product)&&product.getPrice()<=wallet){
            updateWallet(product.getPrice()*(-1));
            shoppingCart.add(0,product);
            this.store.transact(product,0);
            return true;
        }
        else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:{
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
            case Rating:{
                shoppingCart.sort(Comparator.comparing(Product::getAvgRating));
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
            case Price:{
                shoppingCart.sort(Comparator.comparing(Product::getPrice));
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            this.store.transact(product,1);
            return true;
        }
        else
            return false;
    }

}