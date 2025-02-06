import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    HashMap<Product,Store> hashMap = new HashMap<>();

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if(rating >= 1 && rating <= 5){
            product.setRating(rating);
            return true;
        }else {
            return false;
        }
    }

    public void updateWallet(float amount){
        setWallet(getWallet() + amount);
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && getWallet() >= product.getPrice()){
            store.setIncome(store.getIncome() + product.getPrice());
            store.removeProduct(product);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            hashMap.put(product,store);
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> list = new ArrayList<>(shoppingCart);
        switch (sortMethod){
            case Price:
                list.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2){
                        return Float.compare(p1.getPrice(), p2.getPrice());
                    }
                });
                for (Product Pro : list){
                    System.out.println(Pro);
                }
                break;
            case PurchaseTime:
                for (Product Pro : list){
                    System.out.println(Pro);
                }
                break;
            case Rating:
                list.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return Float.compare(p1.getAvgRating(), p2.getAvgRating());
                    }
                });
                for (Product Pro : list){
                    System.out.println(Pro);
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        if (hashMap.containsKey(product)){
            hashMap.get(product).transact(product,1);

            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            hashMap.remove(product);
            return true;
        } else{
            return false;
        }
    }

    public static int getCnt() {
        return cnt;
    }
    public static void setCnt(int cnt) {
        Customer.cnt = cnt;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }
    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    public float getWallet() {
        return wallet;
    }
    public void setWallet(float wallet) {
        this.wallet = wallet;
    }
}
