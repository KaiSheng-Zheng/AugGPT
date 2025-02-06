import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private HashMap<Product, Store> purchasedHistory = new HashMap<>();
    private float wallet;
    public Customer(String name,float wallet){
        this.name=name;this.wallet=wallet;this.shoppingCart=new ArrayList<>();Customer.cnt++;this.id=Customer.cnt;
    }
    public boolean rateProduct(Product product,int rating){
       return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){store.transact(product,0);
            wallet-=product.getPrice();this.shoppingCart.add(product);
            this.purchasedHistory.put(product,store);return true;}
        else return false;}
    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> CopyList = new ArrayList<>();
        for (Product product:shoppingCart){CopyList.add(product);}
        switch (sortMethod) {
            case PurchaseTime: for (Product product : CopyList) {
                    System.out.println(product);}break;
            case Rating: CopyList.sort((x, y) -> Float.compare(x.getAvgRating(), y.getAvgRating()));
                for (Product product : CopyList) {
                    System.out.println(product);}break;
            case Price: CopyList.sort((x, y) -> Float.compare(x.getPrice(), y.getPrice()));
                for (Product product : CopyList) {
                    System.out.println(product);}break;}}
    public boolean refundProduct(Product product) {
        if (this.shoppingCart.contains(product)) {
            this.shoppingCart.remove(product);
            this.wallet += product.getPrice();
            this.purchasedHistory.get(product).transact(product, 1);
            this.purchasedHistory.remove(product);
            return true;
        }
        return false;
    }
}