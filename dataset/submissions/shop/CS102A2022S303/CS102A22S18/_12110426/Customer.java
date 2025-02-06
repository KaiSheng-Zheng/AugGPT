import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;
    HashMap<Product,Store> man = new HashMap<>();
    public Customer(String name, float wallet){
        this.name=name;this.wallet=wallet;cnt++;this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating>=1&&rating<=5){
            product.setRating(rating);return true;
        }else
            return false;

    }
    public void updateWallet(float amount){
        this.wallet=this.wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>= product.getPrice()){
            shoppingCart.add(product);updateWallet(-product.getPrice());store.transact(product,0);man.put(product,store);return true;
        }else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.PurchaseTime){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }else if (sortMethod==SortBy.Price){
            ArrayList<Product> arr = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                arr.add(shoppingCart.get(i));
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i+1; j < shoppingCart.size(); j++) {
                    if (arr.get(j).getPrice()<arr.get(i).getPrice()){
                        Product tem=arr.get(i);
                        arr.set(i,arr.get(j));
                        arr.set(j,tem);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(arr.get(i).toString());
            }
        }else if (sortMethod==SortBy.Rating) {
            ArrayList<Product> arr1 = new ArrayList<>();
            for (int i = 0; i < shoppingCart.size(); i++) {
                arr1.add(shoppingCart.get(i));
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i + 1; j < shoppingCart.size(); j++) {
                    if (arr1.get(j).getAvgRating() < arr1.get(i).getAvgRating()) {
                        Product tem1 = arr1.get(i);
                        arr1.set(i, arr1.get(j));
                        arr1.set(j, tem1);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(arr1.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);updateWallet(product.getPrice());man.get(product).transact(product,1);
            return true;
        }else
            return false;
    }

}