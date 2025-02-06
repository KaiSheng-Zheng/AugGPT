import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;


    public Customer(String name, float wallet){
        id = ++cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.removeProduct(product)){
            product.markFrom(store);
            updateWallet(- product.getPrice());
            shoppingCart.add(product);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> ShoppingCart = shoppingCart;
//        ShoppingCart.sort(new Comparator<Product>() {
        ShoppingCart.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                float flag = 0;
                switch (sortMethod) {
                    case Price -> flag = o1.getPrice() - o2.getPrice();
                    case Rating -> flag = o1.getAvgRating() - o2.getAvgRating();
                    case PurchaseTime -> flag = 0;
                    default -> flag = 0;
                }
                return flag > 0 ? 1 : (flag < 0 ? -1 : 0);
            }
        });
        for (Product product : ShoppingCart)
            System.out.println(product);
    }

    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product))
            return false;
        shoppingCart.remove(product);
        updateWallet(product.getPrice());
        product.getStore().transact(product, 1);
        product.markFrom(null);
        return true;
    }
}