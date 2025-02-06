import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt+=1;
        this.id=cnt;
        this.shoppingCart=new ArrayList<Product>();
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)){
            return true;
        }
        else{
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            shoppingCart.add(product);
            wallet-= product.getPrice();
            return false;
        }
        else{
            return true;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.Rating){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int)(o1.getAvgRating()-o2.getAvgRating());
                }
            });
        }
        if(sortMethod==SortBy.Price){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int)(o1.getPrice()-o2.getPrice());
                }
            });
        }

    }


}