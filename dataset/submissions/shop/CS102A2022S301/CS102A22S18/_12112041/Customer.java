import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
        shoppingCart=new ArrayList<Product>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet=wallet+amount;
    }

    public boolean purchaseProduct(Store store,Product product){
        if(wallet>= product.getPrice()&& store.hasProduct(product)){
            this.updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.equals(SortBy.PurchaseTime)){
            for(Product content:this.shoppingCart){
                System.out.println(content);
            }
        }
        else if(sortMethod.equals(SortBy.Rating)){
            this.shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getAvgRating() < o2.getAvgRating()) {
                        return -1;
                    }
                    else if(o1.getAvgRating() > o2.getAvgRating()){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
            });
            for(Product content:this.shoppingCart){
                System.out.println(content);
            }
        }
        else{
            this.shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getPrice() < o2.getPrice()) {
                        return -1;
                    }
                    else if(o1.getPrice() > o2.getPrice()){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
            });
            for(Product content:this.shoppingCart){
                System.out.println(content);
            }
        }
    }

    public boolean refundProduct(Product product){
        return true;
    }
}