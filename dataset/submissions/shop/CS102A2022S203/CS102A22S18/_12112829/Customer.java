import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer{
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Integer,Store> storeID=new HashMap<>();

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        setWallet(amount+getWallet());
    }

    public boolean purchaseProduct(Store store, Product product){
        if (wallet >= product.getPrice() && store.hasProduct(product)){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            storeID.put(product.getId(), store);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (Product product:shoppingCart){
                    System.out.println(product);
                }
                break;
            case Rating:
                Product[] shopping1=new Product[shoppingCart.size()];
                int x=0;
                for(Product product:shoppingCart){
                    shopping1[x]=shoppingCart.get(x);
                    x++;
                }
                Arrays.sort(shopping1,new sortRating());
                for(Product product:shopping1){
                    System.out.println(product);
                }
                break;
            case Price:
                Product[] shopping2=new Product[shoppingCart.size()];
                int y=0;
                for(Product product:shoppingCart){
                    shopping2[y]=shoppingCart.get(y);
                    y++;
                }
                Arrays.sort(shopping2,new sortPrice());
                for(Product product:shopping2){
                    System.out.println(product);
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        if (storeID.containsKey(product.getID())){
                updateWallet(product.getPrice());
                shoppingCart.remove(product);
                Store s =storeID.get(product.getId());
                s.transact(product,1);
                storeID.remove(product.getId());
                return true;
        }else {
            return false;
        }
    }
}