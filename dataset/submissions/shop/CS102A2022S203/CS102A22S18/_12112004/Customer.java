import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){

    }
    public boolean rateProduct(Product product, int rating){
        return true;
    }
    public void updateWallet(float amount){

    }
    public boolean purchaseProduct(Store store, Product product){
        return true;
    }
    public void viewShoppingCart(SortBy sortMethod){

    }
    public boolean refundProduct(Product product){
        return true;
    }
}