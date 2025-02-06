import java.util.ArrayList;
import java.util.Comparator;
import static java.util.Comparator.comparing;
public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){return product.setRating(rating);}
    public void updateWallet(float amount){wallet+=amount;}
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>= product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            updateWallet((-1)* product.getPrice());
            return true;
        }
        else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){

        switch (sortMethod){
            case PurchaseTime:for (int i=0;i<shoppingCart.size()-1;i++){
                System.out.println(shoppingCart.get(i).toString());
            }break;
            case Price:ArrayList<Product> copy1=shoppingCart;
            copy1.sort(Comparator.comparing(Product::getPrice));
                for (int i=0;i<copy1.size();i++){
                    System.out.println(copy1.get(i).toString());
                }break;
            case Rating:ArrayList<Product> copy2=shoppingCart;
                copy2.sort(Comparator.comparing(Product::getAvgRating));
                for (int i=0;i<copy2.size();i++){
                    System.out.println(copy2.get(i).toString());
                }break;
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }
        else {
            return false;
        }
    }
}

