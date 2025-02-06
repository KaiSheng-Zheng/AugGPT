import java.util.*;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    HashMap<Product, Store> hm = new HashMap<>();

    public Customer(String name, float wallet){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating)){
            return true;
        }
        return false;
    }

    public void updateWallet(float amount){
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&product.getPrice() <= wallet){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            hm.put(product, store);
            return true;
        }
        else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime -> {
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
            }

            case Price -> {
                shoppingCart.sort((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()));
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
            }

            case Rating -> {
                shoppingCart.sort((o1, o2) -> Float.compare(o1.getAvgRating(), o2.getAvgRating()));
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
            }
        }
    }

    public boolean refundProduct(Product product){
        for (int i = 0; i < shoppingCart.size(); i++){
            if (shoppingCart.get(i) == product){
                shoppingCart.remove(product);
                updateWallet(product.getPrice());
                hm.get(product).transact(product,1);
                return true;
            }
        }
        return false;
    }
}
