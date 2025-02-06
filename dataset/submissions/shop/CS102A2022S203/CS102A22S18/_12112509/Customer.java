import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet){
    this.name=name;
    this.wallet=wallet;
    cnt++;
    id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating<1 ||rating>5){
            return false;
        }else {
            return true;
        }
    }
    public void updateWallet(float amount){
        wallet=wallet-amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product)||wallet>0){
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){


        }

    public boolean refundProduct(Product product){

    return true;


}
    }

