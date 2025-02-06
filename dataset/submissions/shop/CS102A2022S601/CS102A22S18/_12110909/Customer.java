import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product>shoppingCart=new ArrayList<>();
    private float wallet;
    static HashMap<Integer,Store>hashMap=new HashMap<>();

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public float getWallet() {
        return wallet;
    }

    public Customer(String name, float wallet){
        this.wallet=wallet;
        this.name=name;
        cnt++;
        this.id=cnt;
    }

    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        setWallet(getWallet()+amount);
    }

    public boolean purchaseProduct(Store store,Product product){
        if (store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            hashMap.put(product.getId(),store);
            shoppingCart.add(product);
            return true;
        }
        else return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:{
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            }
            case Rating:{
                ArrayList<Product>rating=new ArrayList<>(shoppingCart.size());
                rating.addAll(shoppingCart);
                rating.sort(Comparator.comparing(Product::getAvgRating));
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            }
            case Price:{
                ArrayList<Product>price=new ArrayList<>(shoppingCart.size());
                price.addAll(shoppingCart);
                price.sort(Comparator.comparing(Product::getPrice));
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;
            }
        }
    }

    public boolean refundProduct(Product product){
        if (hashMap.containsKey(product.getId())){
            hashMap.remove(product.getId());
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            hashMap.get(product.getId()).transact(product,-1);
            return false;
        }
        else return false;
    }
}

