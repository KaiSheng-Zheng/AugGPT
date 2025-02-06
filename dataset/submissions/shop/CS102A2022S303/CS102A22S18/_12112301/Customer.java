import java.util.ArrayList;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store>   stores  = new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
        this.name = name;

    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
            this.wallet += amount;

    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && (wallet > product.getPrice())){
            updateWallet(-product.getPrice());
            store.transact(product,0);
            shoppingCart.add(product);
            stores.add(store);
            return true;
        }
        return false;

    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod == SortBy.PurchaseTime )
        {
            for(Product p : shoppingCart){
                System.out.println(p);
            }
        }else if(sortMethod == SortBy.Rating){
            if(shoppingCart.size() > 0) {
                Product[] cart = new Product[shoppingCart.size()];
                shoppingCart.toArray(cart);
                sortByRating(cart);
                for (Product p : cart) {
                    System.out.println(p);
                }
            }
        } else if(sortMethod == SortBy.Price){
            if(shoppingCart.size() > 0) {
                Product[] cart = new Product[shoppingCart.size()];
                shoppingCart.toArray(cart);
                sortByPrice(cart);
                for (Product p : cart) {
                    System.out.println(p);
                }
            }
        }
    }
    public void sortByRating(Product[] k) {
        int n = k.length;
        for (int i = 0; i < n; i++) {
            Product value = k[i];
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (value.getAvgRating() > k[j].getAvgRating()) {
                    value = k[j];
                    index = j;
                }
            }
            k[index] = k[i];
            k[i] = value;
        }
    };
    public void sortByPrice(Product[] k) {
        int n = k.length;
        for (int i = 0; i < n; i++) {
            Product value = k[i];
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (value.getPrice() > k[j].getPrice()) {
                    value = k[j];
                    index = j;
                }
            }
            k[index] = k[i];
            k[i] = value;
        }
    };
    public boolean refundProduct(Product product){
        for(Product p : shoppingCart){
            if(p.getId() == product.getId()){
                updateWallet(product.getPrice());
                shoppingCart.remove(product);
                //find store
                for (Store s : stores) {
                    if (s.getId() == product.getStoreid()) {
                        s.transact(product,1);
                        stores.remove(s);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
