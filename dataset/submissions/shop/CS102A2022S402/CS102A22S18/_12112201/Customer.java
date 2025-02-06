
import java.util.ArrayList;
import java.util.Arrays;
public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private Store store1;
    private float wallet;

    public Customer(String name, float wallet) {
        id = ++cnt;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        switch (sortMethod){
            case PurchaseTime:{
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
            }
            case Rating:{
                Product[] latest1=new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    latest1[i]=shoppingCart.get(i);
                }
                Arrays.sort(latest1, (o1, o2) -> {
                    if(o1.getAvgRating()>=o2.getAvgRating()){
                        return 1;
                    }else {
                        return -1;
                    }
                });
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(latest1[i].toString());
                }
                break;
            }
            case Price:{
                Product[] latest2=new Product[shoppingCart.size()];
                for (int i = 0; i < shoppingCart.size(); i++) {
                    latest2[i]=shoppingCart.get(i);
                }
                Arrays.sort(latest2, (o1, o2) -> {
                    if(o1.getAvgRating()>=o2.getPrice()){
                        return 1;
                    }else {
                        return -1;
                    }
                });
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(latest2[i].toString());
                }
                break;
            }
        }

    }
    public boolean refundProduct(Product product) {
        if(shoppingCart.contains(product)){
            Store store=store1;
            store.addProduct(product);
            store.transact(product,1);
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            return true;
        }
        return false;
    }
}
