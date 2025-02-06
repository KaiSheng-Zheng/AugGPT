
import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public float getWallet(){
        return wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            product.setSource(store);
            shoppingCart.add(product);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        int[] x = new int[shoppingCart.size()];
        for (int i = 0; i < shoppingCart.size(); i++) x[i] = i;
        int t;
        switch (sortMethod){
            case PurchaseTime -> {
                for (Product p:shoppingCart){
                    System.out.println(p);
                }
            }
            case Rating -> {
                for (int i = 0; i < shoppingCart.size(); i++){
                    for (int j = i + 1; j < shoppingCart.size(); j++) {
                        if(shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating());
                        t = x[i]; x[i] = x[j]; x[j] = t;
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) System.out.println(shoppingCart.get(x[i]));
            }
            case Price -> {
                for (int i = 0; i < shoppingCart.size(); i++){
                    for (int j = i + 1; j < shoppingCart.size(); j++) {
                        if(shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice());
                        t = x[i]; x[i] = x[j]; x[j] = t;
                    }
                }
                for (int i = 0; i < shoppingCart.size(); i++) System.out.println(shoppingCart.get(x[i]));
            }
        }
    }
    public boolean refundProduct(Product product){
        if (hasProduct(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.getSource().transact(product,1);
            return true;
        }
        return false;
    }
    public boolean hasProduct(Product product){
        for (Product p:shoppingCart){
            if (product.getId() == p.getId()) return true;
        }
        return false;
    }
}

