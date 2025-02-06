import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private HashMap<Object, Object> chase;
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products;default is empty.
    private float wallet;

    public Customer(String name, float wallet){
        id=++cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
        this.chase=new HashMap<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(isaBoolean(store, product)){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            boolean add;
            add = shoppingCart.add(product);
            Object put;
            put = chase.put(product.getId(

            ), store);
            return true;
        }
        return false;
    }

    private boolean isaBoolean(Store store, Product product) {
        return store.hasProduct(product) && product.getPrice() <= wallet;
    }

    public void viewShoppingCart(SortBy sortMethod){
        //System.out.println("!");
        if (sortMethod == SortBy.PurchaseTime) for (Product product : shoppingCart) {
            System.out.println(product.toString());
        }
        else if (sortMethod == SortBy.Rating) {
            Product[] tmp;
            tmp = new Product[shoppingCart.size()];
            int bound = shoppingCart.size();
            for (int i = 0; i < bound; i++) tmp[i] = shoppingCart.get(i);
            Arrays.sort(tmp, new SortByRating());
            //System.out.println("!");
            int i = 0, tmpLength = tmp.length;
            while (i < tmpLength) {
                Product product;
                product = tmp[i];
                System.out.println(product.toString());
                i++;
            }
        } else if (sortMethod == SortBy.Price) {//System.out.println("!");
            Product[] tmp = new Product[shoppingCart.size()];
            int i = 0;
            while (i < shoppingCart.size()) {
                tmp[i] = shoppingCart.get(i);
                i++;
            }
            Arrays.sort(tmp, new SortByPrice());
            int j = 0, tmpLength = tmp.length;
            while (j < tmpLength) {
                Product product = tmp[j];
                System.out.println(product.toString());
                j++;
            }
        }
    }
    public boolean refundProduct(Product product){
        if (!chase.containsKey(product.getId())) return false;
        Store store;
        store = (Store) chase.get(product.getId());
        store.transact(product,1);
        Product remove;
        remove = shoppingCart.remove(shoppingCart.indexOf(product));
        updateWallet(product.getPrice());
        Object remove1;
        remove1 = chase.remove(product.getId());
        return true;
    }

    private class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2){
            if (p2.getAvgRating() <= p1.getAvgRating()) {
                return 1;
            }
            return -1;
        }
    }
    private class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product p1, Product p2){
            if (p2.getPrice() <= p1.getPrice()) return 1;
            return -1;
        }
    }
}
