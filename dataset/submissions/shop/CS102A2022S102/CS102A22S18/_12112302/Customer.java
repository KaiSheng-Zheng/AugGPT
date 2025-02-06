import java.util.ArrayList;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
        this.shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        boolean b=product.setRating(rating);
        return b;
    }

    public void updateWallet(float amount) {
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        boolean situation=true;
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            situation=true;
            shoppingCart.add(product);
            product.setStore(store);
            store.transact(product,0);
            float amount=-product.getPrice();
            updateWallet(amount);
        }else
            situation=false;
        return situation;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void viewShoppingCart(SortBy sortMethod){
        sortMethod.Sort(sortMethod,shoppingCart);
    }

    public boolean refundProduct(Product product){
        boolean b=false;
        Store store=product.getStore();
        if(this.shoppingCart.contains(product)){
            b=true;
            wallet+=product.getPrice();
            shoppingCart.remove(product);
            store.transact(product,1);
        }
        return b;
    }
}
