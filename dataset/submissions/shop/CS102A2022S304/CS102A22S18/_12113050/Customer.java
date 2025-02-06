import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
        shoppingCart= new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        if (rating==1||rating==2||rating==3||rating==4||rating==5){
            product.setRating(rating);
            return true;
        }else {
            return false;
        }
    }
    public void updateWallet(float amount){
        this.wallet=wallet+amount;

    }
    public boolean purchaseProduct(Store store, Product product){
        if (wallet>= product.getPrice()&&store.hasProduct(product)){
            store.transact(product,0);
            this.wallet=wallet-product.getPrice();
            shoppingCart.add(product);
            product.setStore(store);
            return true;
        }
        else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod==SortBy.Price){
                Product[]P = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                P[i]=shoppingCart.get(i);
            }
            Arrays.sort(P,new SortByPrice());
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(P[i].toString());
            }
            }
        if (sortMethod==SortBy.Rating){
            Product[]P = new Product[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                P[i]=shoppingCart.get(i);
            }
            Arrays.sort(P,new SortByRating());
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(P[i].toString());
            }
        }

        }


    public boolean refundProduct(Product product){
        int x = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (product.getId() == shoppingCart.get(i).getId()) {
                x = 1;
            }
        }
        if (x == 1) {
            shoppingCart.remove(product);
            this.wallet =wallet+ product.getPrice();
            product.getStore().setIncome(product.getStore().getIncome() - product.getPrice());
            product.getStore().addProduct(product);
            return true;
        } else {
            return false;
        }
    }
}
class SortByRating implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getAvgRating() <= p1.getAvgRating() ? 1 : -1;

    }
}

class SortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getPrice() <= p1.getPrice() ? 1 : -1;
    }
}
