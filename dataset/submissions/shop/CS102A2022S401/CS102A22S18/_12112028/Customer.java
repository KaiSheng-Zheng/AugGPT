import java.util.ArrayList;


public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name,float wallet){
        cnt++; id=cnt;
        this.name =name;
        this.wallet =wallet;
    }
    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            boolean rateProduct = false;
            return false;
        } else {
            boolean rateProduct = true;
            return true;
        }
    }
    public void updateWallet(float amount){
        this.wallet =wallet +amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) ==true&& wallet>product.getPrice()){
                return true;
        }else{
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){







    }
    public boolean refundProduct(Product product){
        return true;



    }







}
