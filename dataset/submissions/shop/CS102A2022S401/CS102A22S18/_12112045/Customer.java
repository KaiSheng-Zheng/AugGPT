import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id=cnt;
        shoppingCart=new ArrayList<Product>();
    }

    public boolean rateProduct(Product product, int rating){
        if(rating<=5&&rating>=1){
            product.setRating(rating);
            return true;
        }
        else
            return false;
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.getProductList().contains(product)&&product.getPrice()<=wallet){
            shoppingCart.add(product);
            store.removeProduct(product);
            updateWallet(-product.getPrice());
            store.setIncome(store.getIncome()+product.getPrice());
            return true;
        }
        else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod.equals(SortBy.PurchaseTime)) {
            for(int i = 0;i<shoppingCart.size();i++)
                System.out.println(shoppingCart.get(i).toString());
        }
        else if (sortMethod.equals(SortBy.Rating)) {
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int)(o1.getAvgRating()-o2.getAvgRating());
                }
            });
            for(int i = 0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod.equals(SortBy.Price)){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int)(o1.getPrice()-o2.getPrice()) ;
                }
            });
            for(int i = 0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            return true;
        }
        else
            return false;
    }
}
