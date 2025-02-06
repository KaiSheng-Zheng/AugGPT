import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Arrays;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();
    private float wallet;
    private HashMap<Product,Store> map =new HashMap<>();

    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;

    }

    public boolean rateProduct(Product product, int rating) {
        if (rating <= 5 && rating >= 1) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        if (amount >= 0) {
            wallet = wallet + amount;
        }
        if (amount < 0) {
            wallet = wallet - Math.abs(amount);//?
        }
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            store.transact(product, 0);
            //store.getProductList().remove(product);
            updateWallet(-product.getPrice());
            map.put(product,store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            ArrayList<Product> shoppingCart1 = new ArrayList<Product>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                shoppingCart1.add(shoppingCart.get(i));
                System.out.println(shoppingCart1.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            ArrayList<Product> shoppingCart2 = new ArrayList<Product>(shoppingCart);
            for (int j = 0; j < shoppingCart2.size(); j++) {
                for (int k = shoppingCart2.size() - 1; k > j; k--) {
                    if (shoppingCart2.get(k).getAvgRating() < shoppingCart2.get(k - 1).getAvgRating()) {
                        Product temp = shoppingCart2.get(k - 1);
                        shoppingCart2.set(k - 1, shoppingCart2.get(k));
                        shoppingCart2.set(k, temp);
                    }
                }
                System.out.println(shoppingCart2.get(j).toString());
            }
        }
        if (sortMethod == SortBy.Price) {
            ArrayList<Product> shoppingCart3 = new ArrayList<Product>(shoppingCart);
            for (int l = 0; l < shoppingCart3.size(); l++) {
                for (int m = shoppingCart3.size() - 1; m > l; m--) {
                    if (shoppingCart3.get(m).getPrice() < shoppingCart3.get(m - 1).getPrice()) {
                        Product temp = shoppingCart3.get(m - 1);
                        shoppingCart3.set(m - 1, shoppingCart3.get(m));
                        shoppingCart3.set(m, temp);
                    }
                }
                System.out.println(shoppingCart3.get(l).toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)){
            //determineStore(product,map.get(product));
            shoppingCart.remove(product);
            map.get(product).transact(product,1);
            updateWallet(product.getPrice());
            return true;
        }else{
            return false;
        }
    }
    /*public  Store determineStore (Product product,Store store){
         map.put(product, store);
         return map.get(product);
    }*/
    //public HashMap<Product,Store> returnMap(){

       // return map;
    //}
}



