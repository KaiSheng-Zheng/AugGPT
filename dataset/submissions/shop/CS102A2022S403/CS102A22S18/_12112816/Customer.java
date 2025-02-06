import java.util.*;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        id = ++cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) & wallet >= product.getPrice()){
            updateWallet(-product.getPrice());
            store.transact(product,0);
            product.setOnceBeenIn(store);            //
            shoppingCart.add(product);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
        if (sortMethod.equals(SortBy.Price)){
            ArrayList<Product> shoppingCartCopy = new ArrayList<>(shoppingCart);
            Collections.sort(shoppingCartCopy,new Comparator<Product>() {
                public int compare(Product product1, Product product2){
                    if (product1.getPrice() >= product2.getPrice()) return 1;
                    else return -1;
                }
            });
            for (int i = 0; i < shoppingCartCopy.size(); i++) {
                System.out.println(shoppingCartCopy.get(i));
            }
        }
        if (sortMethod.equals(SortBy.Rating)){
            ArrayList<Product> shoppingCartCopy = new ArrayList<>(shoppingCart);
            Collections.sort(shoppingCartCopy, new Comparator<Product>() {
                @Override
                public int compare(Product product1, Product product2) {
                    if (product1.getAvgRating() >= product2.getAvgRating()) return 1;
                    else return -1;
                }
            });
            for (int i = 0; i < shoppingCartCopy.size(); i++) {
                System.out.println(shoppingCartCopy.get(i));
            }
        }
    }
    public boolean refundProduct(Product product){
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (product.getID() == shoppingCart.get(i).getID()){
                shoppingCart.remove(product);
                updateWallet(product.getPrice());
                product.getOnceBeenIn().transact(product,1);
                return true;
            }
        }
        return false;
    }
}

