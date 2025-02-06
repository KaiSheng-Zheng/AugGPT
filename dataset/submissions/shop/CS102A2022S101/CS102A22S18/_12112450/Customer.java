import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    protected ArrayList<Store> stores;
    public Customer(String name, float wallet) {
        Customer.cnt++;
        this.id = Customer.cnt;
        this.name=name;
        this.wallet=wallet;
        shoppingCart = new ArrayList<>();
        stores=new ArrayList<>();
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }
    public static int getCnt() {
        return cnt;
    }
    public static void setCnt(int cnt) {
        Customer.cnt = cnt;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }
    public ArrayList<Store> getStores() {
        return stores;
    }
    public float getWallet() {
        return wallet;
    }
    public String getName() {
        return name;
    }
    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.getProductList().contains(product) & this.wallet >= product.getPrice()) {
            store.getProductList().remove(product);//remove product from array list
            this.wallet-= product.getPrice(); store.setIncome(store.getIncome() + product.getPrice());
            shoppingCart.add(product); stores.add(store);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCart1=new ArrayList<>();
        shoppingCart1 = (ArrayList)shoppingCart.clone();
        if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < shoppingCart1.size() - 1; i++) {
                for (int j = 0; j < shoppingCart1.size() - i - 1; j++)
                    if (shoppingCart1.get(j).getAvgRating()> shoppingCart1.get(j + 1).getAvgRating()) {
                        // swap arr[j+1] and arr[j]
                        Product a = shoppingCart1.get(j); Product b =shoppingCart1.get(j+1);
                        shoppingCart1.set(j,b);shoppingCart1.set(j+1,a);}}
            for (Product x : shoppingCart1)
                System.out.println(x);
        }
        else if (sortMethod == SortBy.Price) {
            for (int i = 0; i < shoppingCart1.size() - 1; i++) {
                for (int j = 0; j < shoppingCart1.size() - i - 1; j++)
                    if (shoppingCart1.get(j).getPrice() > shoppingCart1.get(j + 1).getPrice()) {
                        // swap arr[j+1] and arr[j]
                        Product a = shoppingCart1.get(j); Product b =shoppingCart1.get(j+1);
                        shoppingCart1.set(j,b);shoppingCart1.set(j+1,a);}
            }
            for (Product x : shoppingCart1)
                System.out.println(x);
        }
        else if (sortMethod == SortBy.PurchaseTime)
            for (Product x : shoppingCart)
                System.out.println(x);
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)) {
            //System.out.println(wallet);
            for (int i = 0; i < stores.size(); i++) {
                if (shoppingCart.get(i)==product){
                    Store store = stores.get(i);
                    store.getProductList().add(product);
                    //System.out.println(store.getIncome());
                    this.wallet+= product.getPrice(); store.setIncome(store.getIncome() - product.getPrice());
                    //System.out.println(store.getIncome());
                    break;
                }
            }
            //System.out.println(wallet);
            return true;
        }
        return false;
    }

}
