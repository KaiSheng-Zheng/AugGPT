import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Integer,Store> whichStore;

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        this.whichStore = new HashMap<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            updateWallet(-product.getPrice());
            this.shoppingCart.add(product);
            store.transact(product , 0);
            this.whichStore.put(product.getId() , store);
            return true;
        }return false;
    }

    public boolean refundProduct(Product product){
        if (whichStore.containsKey(product.getId())){
            Store store = whichStore.get(product.getId());
            store.transact(product , 1);
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            whichStore.remove(product.getId());
            return true;
        }return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> newProduct = new ArrayList<>();
        switch (sortMethod) {
            case PurchaseTime: {
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            }
            case Rating: {
                newProduct.addAll(shoppingCart);
                newProduct.sort(new SortByRating());
                for (Product product : newProduct){
                    System.out.println(product.toString());
                }
                break;
            }
            case Price: {
                newProduct.addAll(shoppingCart);
                newProduct.sort(new SortByPrice());
                for (Product product : newProduct) {
                    System.out.println(product.toString());
                }
                break;
            }
        }
    }



    class SortByRating implements Comparator<Product> {
        @Override
        public int compare(Product o1 , Product o2){
            return  o2.getAvgRating() <= o1.getAvgRating()?1:-1;
        }
    }
    class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product o1 , Product o2){
            return (int) (o1.getPrice() - (o2.getPrice()));
        }
    }
}


