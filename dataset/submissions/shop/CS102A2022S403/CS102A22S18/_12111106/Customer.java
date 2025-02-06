import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet = wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (wallet>product.getPrice() && store.hasProduct(product)){
            wallet = wallet-product.getPrice();
            store.removeProduct(product);
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        for (int i=0; i<shoppingCart.size(); i++){
            System.out.println();
        }
    }
}