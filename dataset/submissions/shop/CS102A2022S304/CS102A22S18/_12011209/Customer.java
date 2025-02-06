import java.util.ArrayList;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
        this.shoppingCart = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            updateWallet(-product.getPrice());
            product.setStore(store);
            shoppingCart.add(product);
            store.transact(product, 0);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> newArray = new ArrayList<>(shoppingCart);
        if(sortMethod == SortBy.PurchaseTime){
            for (Product product: shoppingCart) {
                System.out.println(product.toString());
            }
        }else if(sortMethod == SortBy.Price){
            newArray.sort(new SortByPrice());
            for (Product product: newArray) {
                System.out.println(product.toString());
            }
        }else {
            newArray.sort(new SortByRating());
            for (Product product: newArray) {
                System.out.println(product.toString());
            }
        }
    }


    public boolean refundProduct(Product product) {
        if(shoppingCart.contains(product)){
            shoppingCart.remove(shoppingCart.lastIndexOf(product));
            wallet += product.getPrice();
            product.getStore().transact(product, 1);
            return true;
        }
        else return false;


    }
}

class SortByPrice implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return (int)(o1.getPrice() - o2.getPrice());
    }
}

class SortByRating implements Comparator<Product>{
    @Override
    public int compare(Product o1, Product o2) {
        return (int)(o1.getAvgRating() - o2.getAvgRating());
    }
}


