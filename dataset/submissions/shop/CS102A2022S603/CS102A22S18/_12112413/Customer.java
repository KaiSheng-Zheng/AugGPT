import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart= new ArrayList<Product>();
    private float wallet;

    public Customer(String name, float wallet) {
        Customer.cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating))
            return true;
        return false;
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)==false||this.wallet<product.price)
            return false;
        updateWallet(-product.price);
        store.removeProduct(product);
        this.shoppingCart.add(product);
        return true;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.PurchaseTime){
            for(int i=0;i<this.shoppingCart.size();i++)
                System.out.println(this.shoppingCart.get(i));
        }
    }
}
