import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt = 0;
    private final int id; // unique for each customer and the value is set to cnt.
    private final String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet = 0;
    private static HashMap<Integer,Store> originStore = new HashMap<>();

    public Customer(String name, float wallet){
        this.name = name;
        this.wallet = (float)wallet;
        cnt++;
        this.id = cnt;
    }

    public float getWallet() {
        return wallet;
    }
    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && product.getPrice() <= this.wallet){
            this.updateWallet(-product.getPrice());
            store.transact(product,0);
            this.shoppingCart.add(product);
            originStore.put(product.getId(), store);
            return true;
        } else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCartSorted = shoppingCart;
        switch (sortMethod.ordinal()){
            case 0:
                for (Product product: shoppingCart){
                    System.out.println(product.toString());
                }
                break;
            case 1:
                Collections.sort(shoppingCartSorted, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.compareTo(o2,1);
                    }
                });
                for (Product product: shoppingCartSorted){
                    System.out.println(product.toString());
                }
                break;
            case 2:
                Collections.sort(shoppingCartSorted, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.compareTo(o2,2);
                    }
                });
                for (Product product: shoppingCartSorted){
                    System.out.println(product.toString());
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        if(originStore.containsKey(product.getId())){
            Store oStore = originStore.get(product.getId());
            oStore.transact(product,1);
            originStore.remove(product.getId());
            shoppingCart.remove(product);
            this.updateWallet(product.getPrice());
            return true;
        }
        return false;
    }
}
