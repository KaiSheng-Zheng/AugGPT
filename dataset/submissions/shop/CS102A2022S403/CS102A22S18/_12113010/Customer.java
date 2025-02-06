import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id ;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Product> shoppingCart2 =new ArrayList<>();
    private float wallet;
    private ArrayList<Store> storeList = new ArrayList<>();
    Store s;

    public float getWallet() {
        return wallet;
    }

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product, 0);
            shoppingCart.add(product);
            Product.cont++;
            product.t = Product.cont;
            wallet -= product.getPrice();
            storeList.add(store);
            return true;
        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod){

        if(sortMethod == SortBy.PurchaseTime){
            shoppingCart2.addAll(shoppingCart);
            for (Product product : shoppingCart2) {
                System.out.println(product);
            }
        }
        if(sortMethod == SortBy.Rating){
            ArrayList<Product> shoppingCart3=new ArrayList<>();
            shoppingCart3.addAll(shoppingCart);
            Collections.sort(shoppingCart3,new Comparator<Product>() {
                public int compare(Product o1, Product o2) {
                    if(o1.getAvgRating() - o2.getAvgRating()>0)
                        return  1;
                    else if(o1.getAvgRating() - o2.getAvgRating()<0)
                        return -1;
                    else
                        return 0;
                }
            });
            for (Product product : shoppingCart3) {
                System.out.println(product);
            }
        }
        if(sortMethod == SortBy.Price){
            ArrayList<Product> shoppingCart4=new ArrayList<>();
            shoppingCart4.addAll(shoppingCart);
            Collections.sort(shoppingCart4,new Comparator<Product>() {
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
            for (Product product : shoppingCart4) {
                System.out.println(product);
            }
        }
    }
    public boolean refundProduct(Product product){
        if(!shoppingCart.contains(product)||storeList.size()==0)
            return false;
        else {
            for (int i = 0; i < shoppingCart.size(); i++) {
                if (shoppingCart.get(i).getId() == product.getId()) {
                    storeList.get(i).transact(product, 1);
                    wallet += product.getPrice();
                    storeList.remove(i);
                    shoppingCart.remove(product);
                    break;
                }
            }
        }return true;
    }
}
enum SortBy {
    PurchaseTime, Rating, Price
}