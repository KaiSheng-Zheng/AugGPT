import java.util.*;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();// The list of purchased products;default is empty.
    private List<Product> daan = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            updateWallet(product.getPrice()*-1);
            store.transact(product,0);
            shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.printf("%s\n", shoppingCart.get(i).toString());
                }
                break;
            case Rating:
                Product[]xuenima = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                   xuenima[i] = shoppingCart.get(i);
                }
                Arrays.sort(xuenima,new SortByRating());
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.printf("%s\n", xuenima[i].toString());
                }
                break;
            case Price:
                Product[]zuobulai = new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    zuobulai[i] = shoppingCart.get(i);
                }
                Arrays.sort(zuobulai,new SortByPrice());
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.printf("%s\n", zuobulai[i].toString());
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        return false;//meixiewan
    }
}
class SortByRating implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getAvgRating()<o2.getAvgRating()){
            return -1;
        }else if (o1.getAvgRating()>o2.getAvgRating()){
            return 1;
        }
        else {
            return 0;
        }
    }
}
class SortByPrice implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getPrice()<o2.getPrice()){
            return -1;
        }else if (o1.getPrice()>o2.getPrice()){
            return 1;
        }
        else {
            return 0;
        }
    }
}
