import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private HashMap<Integer,Store> purchase = new HashMap<>();

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            store.transact(product,0);
            shoppingCart.add(product);
            this.wallet -= product.getPrice();
            purchase.put(product.getId(),store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime: {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
            case Rating: {
                ArrayList<Product> temp;
                temp = this.shoppingCart;
                temp.sort(new SortByRating());
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
            case Price: {
                this.shoppingCart.sort(new SortByPrice());
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i));
                }
                break;
            }
        }
    }
    public boolean refundProduct(Product product){
        if(purchase.containsKey(product.getId())){
            Store refundStore = purchase.get(product.getId());
            refundStore.transact(product,1);
            shoppingCart.remove(product);
            this.wallet += product.getPrice();
            purchase.remove(product.getId(),refundStore);
            return true;
        }
        return false;
    }
    static class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return (int)(Math.signum(o1.getAvgRating()-o2.getAvgRating()));
        }
    }
    static class SortByPrice implements Comparator<Product>{

        @Override
        public int compare(Product o1, Product o2) {
            return (int)(Math.signum(o1.getPrice()-o2.getPrice()));
        }
    }
}