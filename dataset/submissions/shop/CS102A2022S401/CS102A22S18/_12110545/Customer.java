import java.util.*;
import java.util.Arrays;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private HashMap<Integer, Store> purchaseFrom;
    private float wallet;

    public Customer(String name, float wallet) {
        id = ++cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        this.purchaseFrom = new HashMap<>();
    }

    public boolean rateProduct(Product product, int rating) {

        return product.setRating(rating);
    }

    public void updateWallet(float amount) {

        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            this.purchaseFrom.put(product.getID(), store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size() - 1; i++) {
                    System.out.println(shoppingCart.get(i).toString());
                    break;
                }
            case Rating:
                Product[] ratingOrder = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    ratingOrder[i] = shoppingCart.get(i);
                }
                Arrays.sort(ratingOrder, new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return p1.getAvgRating() > p2.getAvgRating() ? 1 : -1;
                    }
                });
                //for (int i = 0; i < shoppingCart.size() - 1; i++){
                //for (int j = 0; j < shoppingCart.size() - 1; j++){
                //public int compareTo (ratingOrder[j]) {
                //return ratingOrder[i].getAvgRating()- (ratingOrder[j]).getAvgRating();
                for (int i = 0; i < ratingOrder.length; i++) {
                    System.out.println(ratingOrder[i].toString());
                }
                break;
            case Price:
                Product[] priceOrder = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    priceOrder[i] = shoppingCart.get(i);
                }
                Arrays.sort(priceOrder, new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return p1.getPrice() > p2.getPrice() ? 1 : -1;
                    }
                });
                for (int i = 0; i < priceOrder.length; i++) {
                    System.out.println(priceOrder[i].toString());
                }

        }
    }

    public boolean refundProduct(Product product){
        if(purchaseFrom.containsKey(product.getID())){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            Store store=purchaseFrom.get(product.getID());
            store.transact(product,1);
            purchaseFrom.remove(product.getID());
            return true;
        }
        return false;
    }

}