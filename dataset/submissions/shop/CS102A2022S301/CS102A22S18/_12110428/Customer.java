import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private ArrayList<Store> storeOfProduct = new ArrayList<Store>();
    private float wallet;

    public Customer(String name, float wallet){
        this.id = ++cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating >= 1 && rating <= 5){
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
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            wallet = wallet - product.getPrice();
            store.transact(product, 0);
            return true;
        }
        else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> temp = new ArrayList<Product>();
        for(Product i:shoppingCart){
            temp.add(i);
        }
        if (sortMethod == SortBy.Price) {
            temp.sort(byPrice);
        } else if (sortMethod == SortBy.Rating) {
            temp.sort(byRating);
        }
        for(Product i:temp){
            System.out.println(i);
        }
    }

    public boolean refundProduct(Product product){
        return true;
    }

    Comparator<Product> byTime = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2){
            return shoppingCart.indexOf(p1) - shoppingCart.indexOf(p2);
        }
    };

    Comparator<Product> byRating = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2){
            if(p1.getAvgRating() > p2.getAvgRating()){
                return 1;
            } else if (p1.getAvgRating() < p2.getAvgRating()) {
                return -1;
            } else {
                return byTime.compare(p1, p2);
            }
        }
    };

    Comparator<Product> byPrice = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2){
            if(p1.getPrice() > p2.getPrice()){
                return 1;
            } else if (p1.getPrice() < p2.getPrice()) {
                return -1;
            } else {
                return byTime.compare(p1, p2);
            }
        }
    };
}
