import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        boolean p=store.hasProduct(product);
        if (p&&product.getPrice()<=wallet){
            store.transact(product,0);
            shoppingCart.add(product);
            wallet-= product.getPrice();
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating)){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if ((o1.getAvgRating()-o2.getAvgRating())>-1&&(o1.getAvgRating()-o2.getAvgRating())<0){
                        return (int) Math.floor(o1.getAvgRating()-o2.getAvgRating());
                    }
                    return (int) Math.ceil(o1.getAvgRating()-o2.getAvgRating());
                }
            });
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if ((o1.getPrice()-o2.getPrice())>-1&&(o1.getPrice()-o2.getPrice())<0){
                        return (int) Math.floor(o1.getPrice()-o2.getPrice());
                    }
                    return (int) Math.ceil(o1.getPrice()-o2.getPrice());
                }
            });
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
    }

    public boolean refundProduct(Product product){
        return true;
    }
}