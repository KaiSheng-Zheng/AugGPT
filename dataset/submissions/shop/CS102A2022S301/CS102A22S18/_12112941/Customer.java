import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private ArrayList<Store> count=new ArrayList<>();
    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.wallet=wallet;
        this.name=name;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)==true&&wallet>=product.getPrice()){
            shoppingCart.add(product);
            wallet-= product.getPrice();
            count.add(store);
            store.transact(product,0);

            return true;
        }
        else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.Price){
            Comparator<Product> comparator=new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPrice()>o2.getPrice())
                        return 1;
                    else if (o1.getPrice()==o2.getPrice())
                        return 0;
                    else
                        return -1;
                }
            };
            ArrayList<Product> copy=new ArrayList<>(shoppingCart);
            Collections.sort(copy,comparator);
            for (int i = 0; i < copy.size(); i++) {
                System.out.println(copy.get(i));
            }

        }
        if (sortMethod==SortBy.Rating){
            Comparator<Product> comparator=new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getAvgRating()>o2.getAvgRating())
                        return 1;
                    else if (o1.getAvgRating()==o2.getAvgRating())
                        return 0;
                    else
                        return -1;
                }
            };
            ArrayList<Product> copy=new ArrayList<>(shoppingCart);
            Collections.sort(copy,comparator);
            for (int i = 0; i < copy.size(); i++) {
                System.out.println(copy.get(i));
            }
        }
        if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
    }


    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            for (int i = 0; i < count.size(); i++) {
                if (count.get(i).list.contains(product)) {
                    count.get(i).transact(product, 1);
                    return true;
                }
            }

        }
        else
            return false;
        return false;
    }


}
enum SortBy{
    PurchaseTime,Rating,Price
}
