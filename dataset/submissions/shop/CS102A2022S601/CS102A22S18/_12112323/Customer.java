import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer {
    private static int cnt;
    private int id;
    private ArrayList<Product> shoppingCart;

    private float wallet;
    private String name;

    public Store [] path ;

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Customer.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public Store[] getPath() {
        return path;
    }

    public void setPath(Store[] path) {
        this.path = path;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=Math.round(wallet * 100) / 100f;
        setCnt(getCnt()+1);
        setId(getCnt());
        this.shoppingCart=new ArrayList<>();
        this.path=new  Store [100000];
    }
    public boolean rateProduct(Product product, int rating){
boolean result;
result=product.setRating(rating);
return result;
    }

    public boolean purchaseProduct(Store store, Product product){
            if (getWallet() >= product.getPrice() && store.hasProduct(product)){
                shoppingCart.add(product);
              path[product.getId()]=store;
                updateWallet(- product.getPrice());
               store.transact(product,0);
                 return true;
            }
            else {
                return false;
            }

    }
    public void updateWallet(float amount){
        setWallet(getWallet()+amount);
    }
    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shoppingCart1 = new ArrayList<>(shoppingCart);
        ArrayList<Float> op=new ArrayList<>();
        for (int a = 0;a<shoppingCart.size();a++){
            op.add(shoppingCart.get(a).getAvgRating());
        }
        ArrayList<Float> money=new ArrayList<>();
        for (int a = 0;a<shoppingCart.size();a++){
           money.add(shoppingCart.get(a).getPrice());
        }
        switch (sortMethod) {
            case PurchaseTime:
            for (int a = 0; a < shoppingCart1.size(); a++) {
                System.out.println(shoppingCart1.get(a).toString());
            }
         break;
            case Rating:
            float[] fan = new float[op.size()];
            for (int a = 0; a < op.size(); a++) {
                fan[a] = op.get(a);
            }
            Arrays.sort(fan);
            for (int b = 0; b < fan.length; b++) {
                for (int c = 0; c < shoppingCart1.size(); c++) {
                    if (shoppingCart1.get(c).getAvgRating() == fan[b]) {
                        System.out.println(shoppingCart1.get(c).toString());
                        shoppingCart1.remove(c);
                        c--;
                    }
                }
            }

            break;
            case Price:
            float[] yes = new float[money.size()];
            for (int a = 0; a < money.size(); a++) {
                yes[a] = money.get(a);
            }
            Arrays.sort(yes);
            for (int b = 0; b < yes.length; b++) {
                for (int c = 0; c < shoppingCart1.size(); c++) {
                    if (shoppingCart1.get(c).getPrice() == yes[b]) {
                        System.out.println(shoppingCart1.get(c).toString());
                        shoppingCart1.remove(c);
                        c--;
                    }
                }
            }

            break;
    }
    }

    public boolean refundProduct(Product product){
for (int a = 0;a<shoppingCart.size();a++){
if (shoppingCart.get(a).getId()==product.getId()){
    shoppingCart.remove(product);
    updateWallet( product.getPrice());
path[product.getId()].transact(product,1);
return true;
}
}
return  false;
    }
}
