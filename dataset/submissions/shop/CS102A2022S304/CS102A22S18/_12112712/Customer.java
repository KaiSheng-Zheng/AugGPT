import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> stores;
    public Customer(String name,float wallet){
        shoppingCart = new ArrayList<>();
        stores = new ArrayList<>();
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet = wallet + amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            store.transact(product,0);
            shoppingCart.add(product);
            stores.add(store);
            updateWallet(-product.getPrice());
            return true;
        }else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod == SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i));
            }
        }
        if (sortMethod == SortBy.Rating) {
            Product[] New = new Product[shoppingCart.size()];
            for (int i = 0; i < New.length; i++) {
                New[i] = shoppingCart.get(i);
            }
            for (int i = 0; i < New.length - 1; i++) {
                for (int j = 0; j < New.length - 1 - i; j++) {
                    if (New[j].getAvgRating() > New[j + 1].getAvgRating()) {
                        Product temp = New[j];
                        New[j] = New[j+1];
                        New[j + 1] = temp;
                    }
                }
            }
            for (Product product : New) {
                System.out.println(product);
            }
        }
        if(sortMethod == SortBy.Price){
            Product[] New = new Product[shoppingCart.size()];
            for (int i = 0; i < New.length; i++) {
                New[i] = shoppingCart.get(i);
            }
            for (int i = 0; i < New.length - 1; i++) {
                for (int j = 0; j < New.length - 1 - i; j++) {
                    if (New[j].getPrice() > New[j + 1].getPrice()) {
                        Product temp = New[j];
                        New[j] = New[j+1];
                        New[j + 1] = temp;
                    }
                }
            }
            for (int i = 0; i < New.length; i++) {
                System.out.println(New[i]);
            }
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            stores.get(shoppingCart.indexOf(product)).transact(product,1);
            stores.remove(shoppingCart.indexOf(product));
            shoppingCart.remove(product);
            wallet += product.getPrice();
            return true;
        }else {
            return false;
        }
    }
}
