import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        float temp=this.wallet;
        this.wallet=temp+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&this.wallet>=product.getPrice()){
            float temp=this.wallet;
            this.wallet=temp-product.getPrice();
            this.shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){

    }
    public boolean refundProduct(Product product){
        int temp=product.getStoreID();
        //if (Store.storeList.size()<temp||temp==0) return false;
        Store store=Store.storeList.get(temp-1);
        store.transact(product,1);
        this.shoppingCart.remove(product);
        this.wallet=this.wallet+product.getPrice();
        return true;
    }
}