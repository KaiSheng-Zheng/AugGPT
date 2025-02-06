import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private ArrayList<Store> storelist;

    public ArrayList<Store> getStorelist() {
        return storelist;
    }

    public void setStorelist(ArrayList<Store> storelist) {
        this.storelist = storelist;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
        this.shoppingCart = new ArrayList<>();
        this.storelist = new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        if(rating<6 && rating>0){
            product.setRating(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public void updateWallet(float amount){
        wallet = wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(this.wallet>=product.getPrice() && store.hasProduct(product)){
            shoppingCart.add(product);
            storelist.add(store);
            store.transact(product,0);
            updateWallet(-product.getPrice());
            return true;
        }
        else {
            return false;
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product) && storelist.get(shoppingCart.indexOf(product)).getIncome()>= product.getPrice()){
            (storelist.get(shoppingCart.indexOf(product))).transact(product,1);
            storelist.remove(shoppingCart.indexOf(product));
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            return true;
        }
        else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime){
            for(int i =0;i<shoppingCart.size();i++)
            System.out.println(shoppingCart.get(i).toString());
        }
        else if (sortMethod == SortBy.Rating){
            ArrayList<Product> a = new ArrayList<>(shoppingCart);
            for(int j = a.size() - 1 ;j > 0;j--){
                for(int i = 0; i < j; i++){
                    if(a.get(i+1).getAvgRating()<a.get(i).getAvgRating()){
                        Product b = a.get(i);
                        a.set(i,a.get(i+1));
                        a.set(i+1,b);
                    }
                }
            }
            for(int i =0;i<a.size();i++){
                System.out.println(a.get(i).toString());
            }
        }
        else if (sortMethod == SortBy.Price){
            ArrayList<Product> a = new ArrayList<>(shoppingCart);
            for(int j = a.size() - 1 ;j > 0;j--){
                for(int i = 0; i < j; i++){
                    if(a.get(i+1).getPrice()<a.get(i).getPrice()){
                        Product b = a.get(i);
                        a.set(i,a.get(i+1));
                        a.set(i+1,b);
                    }
                }
            }
            for(int i =0;i<a.size();i++){
                System.out.println(a.get(i).toString());
            }
        }
    }
}
