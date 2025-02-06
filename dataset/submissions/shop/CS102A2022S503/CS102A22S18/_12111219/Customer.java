import java.lang.reflect.Array;
import java.util.*;

public class Customer {
    //Attributes
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.

    public float getWallet() {
        return wallet;
    }

    private float wallet;

    //Constructor
    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
        this.source=new HashMap<>();
//        this.shoppingCart = null;
    }

    //Methods
    public boolean rateProduct(Product product, int rating) {
//        product.setRating(rating);
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            updateWallet((-1) * product.getPrice());
            store.transact(product,0);
            shoppingCart.add(product);
            source.put(product.getId(),store);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod) {
            case PurchaseTime:
                for (int j = 0; j < shoppingCart.size(); j++) {
                    System.out.println(shoppingCart.get(j));
                }
                break;
            case Rating: {
                Product[] sb = new Product[shoppingCart.size()];
                for (int j = 0; j < shoppingCart.size(); j++) {
                    sb[j] = shoppingCart.get(j);
                }
                Arrays.sort(sb, new rt());
                for (int j = 0; j <sb.length;j++){
                    System.out.println(sb[j]);
                }
                    break;
            }


            case Price:{
                Product[] sb = new Product[shoppingCart.size()];
                for (int j = 0; j < shoppingCart.size(); j++) {
                    sb[j] = shoppingCart.get(j);
                }
                    Arrays.sort(sb,new p());
                for (int j = 0; j <sb.length;j++){
                    System.out.println(sb[j]);
                }
                    break;
                }
            }

            }

    public boolean refundProduct(Product product){
    if(shoppingCart.contains(product)){
        source.get(product.getId()).transact(product,1);
        updateWallet(product.getPrice());
        //update
        shoppingCart.remove(product);
        source.remove(product.getId());
        return true;
    }
        return false;
    }

    private HashMap<Integer,Store> source;
}

        class rt implements Comparator<Product> {
            @Override
            public int compare(Product A, Product B) {
                if (A.getAvgRating()>B.getAvgRating()){
                    return 1;
                }else if(A.getAvgRating()<B.getAvgRating()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }

         class p implements Comparator<Product> {
            @Override
            public int compare(Product A, Product B) {
                if (A.getPrice()>B.getPrice()){
                    return 1;
                }else if(A.getPrice()<B.getPrice()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }



