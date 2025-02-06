import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the
    //    constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products;
    //    default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        id=++cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();

    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&product.getPrice()<=wallet){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);

            return true;
        }
        return false;
    }
    private class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product p1,Product p2){if (p1==p2)return 0;
            return p2.getAvgRating()<=p1.getAvgRating()?1:-1;
        }
    }
    private class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product p1,Product p2){if (p1==p2)return 0;
            return p2.getPrice()<=p1.getPrice()?1:-1;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod) {
            case PurchaseTime -> {

                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            }
            case Rating -> {
                Product[] tmp = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    tmp[i] = shoppingCart.get(i);
                }
                Arrays.sort(tmp, new SortByRating());
                //System.out.println("!");
                for (Product product : tmp) {
                    System.out.println(product.toString());
                }
                break;
            }
            case Price -> {
                //System.out.println("!");
                Product[] tmp = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    tmp[i] = shoppingCart.get(i);
                }
                Arrays.sort(tmp, new SortByPrice());
                for (Product product : tmp) {
                    System.out.println(product.toString());
                }
                break;
            }
        }
    }public boolean refundProduct(Product product){return true;}

}