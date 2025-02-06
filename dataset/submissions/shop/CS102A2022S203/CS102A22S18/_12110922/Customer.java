import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private ArrayList<Store> shoppingStore;
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        shoppingCart = new ArrayList<>();
        shoppingStore = new ArrayList<>();
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(wallet >= product.getPrice() && store.hasProduct(product)){
            store.transact(product, 0);
            shoppingStore.add(store);
            shoppingCart.add(product);
            wallet -= product.getPrice();
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.Price){
            Collections.sort(shoppingCart, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getPrice() > o2.getPrice()){
                        return 1;
                    }
                    else if(o1.getPrice() == o2.getPrice()){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
            });
        }
        else if(sortMethod == SortBy.Rating){
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getAvgRating() > o2.getAvgRating()){
                        return 1;
                    }
                    else if(o1.getAvgRating() == o2.getAvgRating()){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
            });
        }
        int i = 0;
        for(i = 0; i < shoppingCart.size(); i++){
            System.out.println(shoppingCart.get(i));
        }
    }
    public boolean refundProduct(Product product){
        int i = 0;
        for(i = 0; i < shoppingCart.size(); i++){
            if(shoppingCart.get(i).getId() == product.getId()){
                wallet += product.getPrice();
                shoppingCart.remove(i);
                shoppingStore.get(i).transact(product, 1);;
                shoppingStore.remove(i);
                return true;
            }
        }
        return false;
    }
}
