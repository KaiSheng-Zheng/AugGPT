import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    public static ArrayList<Store> StoreList =new ArrayList<>();

    public Customer(String name, float wallet){
        cnt+=1;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>= product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            StoreList.add(store);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Price)){
            ArrayList<Product> CartPrice = new ArrayList<>();
            ArrayList<Product> Cart = new ArrayList<>(shoppingCart);
            int l;
            while (Cart.size()!=0) {
                for (Product product1 : Cart) {
                    l=0;
                    for (Product product2 : Cart) {
                        if (product1.getPrice() <= product2.getPrice()) {
                            l++;
                        }
                    }
                    if (l == Cart.size()) {
                        CartPrice.add(product1);
                        Cart.remove(product1);
                        break;
                    }
                }
            }
            for (Product product : CartPrice) {
                System.out.println(product.toString());
            }
        }
        if (sortMethod.equals(SortBy.Rating)){
            ArrayList<Product> CartRating = new ArrayList<>();
            ArrayList<Product> Cart = new ArrayList<>(shoppingCart);
            int l;
            while (Cart.size()!=0) {
                for (Product product1 : Cart) {
                    l=0;
                    for (Product product2 : Cart) {
                        if (product1.getAvgRating() <= product2.getAvgRating()) {
                            l++;
                        }
                    }
                    if (l == Cart.size()) {
                        CartRating.add(product1);
                        Cart.remove(product1);
                        break;
                    }
                }
            }
            for (Product product : CartRating) {
                System.out.println(product.toString());
            }
        }
    }
    public boolean CartHaveProduct(Product product){
        for (Product v:shoppingCart){
            if (v==product){
                return true;
            }
        }
        return false;
    }
    public boolean refundProduct(Product product){
        if (CartHaveProduct(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            for (Store store : StoreList) {
                if (product.getStoreId() == store.getId()) {
                    store.transact(product, 1);
                    break;
                }
            }
            return true;
        }
        else return false;
    }
}
