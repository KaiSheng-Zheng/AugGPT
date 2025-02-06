import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Integer> buyStore;

    public Customer(String name, float wallet){
        cnt++;
        this.id= cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        this.buyStore = new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            //wallet -= product.getPrice();
            store.transact(product,0);
            buyStore.add(store.getId());
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime) {
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
            return;
        }
        ArrayList<Product> i = new ArrayList<>(shoppingCart);
        if(sortMethod == SortBy.Price){
            i.sort(new SortByPrice());
        }
        if(sortMethod == SortBy.Rating){
            i.sort(new SortByRating());
        }
        for (Product product : i) {
            System.out.println(product);
        }
    }

    public boolean refundProduct(Product product){
        for (int i = 0; i < shoppingCart.size(); i++) {
            if(shoppingCart.get(i).getId() == product.getId()){
                shoppingCart.remove(i);
                //wallet += product.getPrice();
                updateWallet(product.getPrice());
                int s = buyStore.get(i);
                buyStore.remove(i);
                Store.storeList.get(s-1).transact(product,1);
                return true;
            }
        }
        return false;
    }
}


class SortByPrice implements Comparator<Product>{
    @Override
    public int compare(Product o1,Product o2) {
        return (int)(o1.getPrice()-o2.getPrice());
    }
}
class SortByRating implements Comparator<Product>{
    @Override
    public int compare(Product o1,Product o2) {
        return (int)(o1.getAvgRating()-o2.getAvgRating());
    }
}
