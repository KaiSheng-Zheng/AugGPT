import java.rmi.server.LogStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private final int id;
    private final String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private static int time;
    private HashMap<Product,Store> ak=new HashMap<>();

    public Customer(String name,float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if(rating>=1&&rating<=5){
            product.getRatings().add(rating);
            return true;
        }else return false;
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
        return;
    }
    public boolean purchaseProduct(Store store, Product product){
        boolean procheck=store.hasProduct(product);
        if(procheck &&wallet>=product.getPrice()){
            wallet=wallet-product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            ak.put(product,store);
            time++;
            product.purchasetime=time;
            return true;
        }else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case Price :
                shoppingCart.sort(Comparator.comparingInt(i -> (int) i.getPrice()*10));
                for(Product product:shoppingCart){
                    System.out.println(product);
                }
                break;
            case Rating:
                shoppingCart.sort(Comparator.comparingInt(i->(int)i.getAvgRating()*100));
                for(Product product:shoppingCart){
                    System.out.println(product);
                }
                break;
            case PurchaseTime:
                shoppingCart.sort(Comparator.comparingInt(i->(int)i.purchasetime));
                for (Product product:shoppingCart){
                    System.out.println(product);
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        boolean buyCheck=shoppingCart.stream().anyMatch(i-> product.getId() == i.getId());
        if(buyCheck){
            shoppingCart.remove(product);
            wallet=wallet+product.getPrice();
            ak.get(product).transact(product,1);
            return true;
        }else return false;
    }
}
