import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&(wallet >= product.getPrice())){
            shoppingCart.add(product);
            store.removeProduct(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }

        if (sortMethod.equals(SortBy.Rating)){
            ArrayList<Product> newShoppingCart = new ArrayList<>(rating(shoppingCart));
            for (Product product : newShoppingCart) {
                System.out.println(product);
            }
        }

        if (sortMethod.equals(SortBy.Price)){
            ArrayList<Product> newShoppingCart = new ArrayList<>(price(shoppingCart));
            for (Product product : newShoppingCart) {
                System.out.println(product);
            }
        }
    }

    public static ArrayList<Product> rating(ArrayList<Product> shoppingCart){
        ArrayList<Product> newShoppingCart = new ArrayList<>(shoppingCart);

        Product temp;
        for (int i = 0; i < newShoppingCart.size()-1; i++) {
            boolean flag = false;
            for (int j = 0; j < newShoppingCart.size()-1-i; j++) {
                if (newShoppingCart.get(j).getAvgRating() > newShoppingCart.get(j+1).getAvgRating()){
                    temp = newShoppingCart.get(j);
                    newShoppingCart.set(j,newShoppingCart.get(j+1));
                    newShoppingCart.set(j+1,temp);
                    flag = true;
                }
            }
            if(!flag) break;
        }

        return newShoppingCart;
    }

    public static ArrayList<Product> price(ArrayList<Product> shoppingCart){
        ArrayList<Product> newShoppingCart = new ArrayList<>(shoppingCart);

        Product temp;
        for (int i = 0; i < newShoppingCart.size()-1; i++) {
            boolean flag = false;
            for (int j = 0; j < newShoppingCart.size()-1-i; j++) {
                if (newShoppingCart.get(j).getPrice() > newShoppingCart.get(j+1).getPrice()){
                    temp = newShoppingCart.get(j);
                    newShoppingCart.set(j,newShoppingCart.get(j+1));
                    newShoppingCart.set(j+1,temp);
                    flag = true;
                }
            }
            if(!flag) break;
        }

        return newShoppingCart;
    }

    public boolean refundProduct(Product product){
        return false;
    }
}
