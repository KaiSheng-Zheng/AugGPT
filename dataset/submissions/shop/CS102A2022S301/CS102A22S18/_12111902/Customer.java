import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    private HashMap<Product,Store> receipt=new HashMap<>();

    public Customer(String name, float wallet){
        cnt+=1;
        this.id=cnt;

        this.name=name;
        this.wallet=wallet;
    }

    public boolean hasProduct(Product product){
        return shoppingCart.contains(product);
    }

    public boolean rateProduct(Product product, int rating){

        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){

        if (store.hasProduct(product)&wallet>=product.getPrice()){

            receipt.put(product,store);
            shoppingCart.add(product);
            wallet-=product.getPrice();

            store.transact(product,0);


            return true;
        }else {
            return false;
        }


    }

    public void viewShoppingCart(SortBy sortMethod){

        sortMethod.setShoppingCart(shoppingCart);
        sortMethod.showShoppingCart();

    }
    public boolean refundProduct(Product product){

        if (hasProduct(product)){

            shoppingCart.remove(product);
            wallet+=product.getPrice();

            receipt.get(product).transact(product,1);
            return true;
        }else {
            return false;
        }


    }

}
