import java.util.ArrayList;

public class Customer {private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet){}
    public boolean rateProduct(Product product, int rating){return true;
    }
    public void updateWallet(float amount){}
    public boolean purchaseProduct(Store store, Product product){return true;}
    public void viewShoppingCart(SortBy sortMethod){}
    public boolean refundProduct(Product product){return true;}
}
