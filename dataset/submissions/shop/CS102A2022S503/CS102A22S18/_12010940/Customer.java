import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    Comparator<Product> comparator;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        boolean pur = false;
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            pur = true;
            store.transact(product,0);
            shoppingCart.add(product);
            product.upDatePurchaseTime();
            wallet -= product.getPrice();
        }
        return pur;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod) {
            case PurchaseTime:
                comparator = sortByPurchaseTime;
                break;
            case Rating:
                comparator = sortByRating;
                break;
            case Price:
                comparator = sortByPrice;
                break;
        }
        Collections.sort(shoppingCart, comparator);
        for (Product p : shoppingCart) {
            System.out.println(p);
        }
    }

    Comparator<Product> sortByPurchaseTime = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            int a;
            if(o1.getPurchaseTime() > o2.getPurchaseTime()){
                a = -1;
            } else {
                a = 1;
            }
            return a;
        }
    };

    Comparator<Product> sortByRating = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            int comp;
            if(o1.getAvgRating() > o2.getAvgRating()){
                comp = -1;
            } else if(o1.getAvgRating() < o2.getAvgRating()){
                comp = 1;
            } else {
                if(o1.getTrueAvg() > o2.getTrueAvg()){
                    comp = -1;
                } else if(o1.getTrueAvg() < o2.getTrueAvg()){
                    comp = 1;
                } else {
                    if(o1.getPurchaseTime() > o2.getPurchaseTime()){
                        comp = -1;
                    } else {
                        comp = 1;
                    }
                }
            }
            return comp;
        }
    };
    Comparator<Product> sortByPrice = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            int comp;
            if(o1.getPrice() > o2.getPrice()){
                comp = -1;
            } else if(o1.getPrice() < o2.getPrice()){
                comp = 1;
            } else {
                if(o1.getPurchaseTime() > o2.getPurchaseTime()){
                    comp = -1;
                } else {
                    comp = 1;
                }
            }
            return comp;
        }
    };

    public boolean refundProduct(Product product){
        return true;
    }
}
