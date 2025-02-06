import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name,float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
       this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>= product.getPrice()){
             updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.equals(SortBy.PurchaseTime)){
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
        }
        if(sortMethod.equals(SortBy.Rating)) {
            ArrayList<Product> newProduct = new ArrayList<>(shoppingCart);
            Collections.sort(newProduct, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating() >= o2.getAvgRating()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            for (int i = 0; i < newProduct.size(); i++) {
                System.out.println(newProduct.get(i).toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)){
            ArrayList<Product> newProduct=new ArrayList<>(shoppingCart);
            Collections.sort(newProduct, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice()>=o2.getPrice()){
                        return 1;
                    }else {
                        return -1;
                    }
                }
            });
            for (int i = 0; i < newProduct.size(); i++) {
                System.out.println(newProduct.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        return true;
    }
}
