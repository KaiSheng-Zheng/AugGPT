import java.util.ArrayList;
import java.util.Comparator;

enum SortBy{
    Price,PurchaseTime,Rating
}
public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name,float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public boolean purchaseProduct(Store store,Product product){
        if (store.getProductList().contains(product)&&wallet>= product.getPrice()){
            store.transact(product,0);
            product.setStore(store);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.Price){
            ArrayList<Product>copy=new ArrayList<>();
            for (Product i:shoppingCart){
                copy.add(i);
            }
            copy.sort(new SortByPrice());
            for (Product j:copy){
                System.out.println(j.toString());
            }
        }
        if (sortMethod==SortBy.Rating){
            ArrayList<Product>copy=new ArrayList<>();
            for (Product i:shoppingCart){
                copy.add(i);
            }
            copy.sort(new SortByRating());
            for (Product i:copy){
                System.out.println(i.toString());
            }
        }
        if (sortMethod==SortBy.PurchaseTime){
            for (Product i:shoppingCart){
            System.out.println(i.toString());
            }
        }
    }
     public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            product.getStore().transact(product,1);
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            return true;
        }
        else return false;
    }
    private static class SortByPrice implements Comparator<Product>{
        public int compare(Product a,Product b){
            if (b.getPrice()<=a.getPrice()){
                return 1;
            }
            else return -1;
        }
    }
    private static class SortByRating implements Comparator<Product>{
        public int compare(Product a,Product b){
            if (b.getAvgRating()<=a.getAvgRating()){
                return 1;
            }
            else return -1;
        }
    }
}
