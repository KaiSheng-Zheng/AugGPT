
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {
    private static int cnt;
    private int id;
    private  String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private HashMap<Product,Store> s=new HashMap<>();
    public Customer(String name,float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        if (store.hasProduct(product)&&this.wallet>=product.getPrice()){
            this.shoppingCart.add(product);
            wallet-=product.getPrice();
            store.removeProduct(product);
            store.addIncome(product.getPrice());
            s.put(product,store);
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        int n=shoppingCart.size();
        if (n==0){
            return;
        }
        if (sortMethod==SortBy.PurchaseTime){
            for (int i=0;i<n;i++){
                System.out.println(shoppingCart.get(i));
            }
        } else if (sortMethod==SortBy.Price) {
            ArrayList<Product> s=new ArrayList<>();
            int y=this.shoppingCart.size();
            for (int i=0;i<y;i++){
                s.add(shoppingCart.get(i));
            }
            float[]a=new float[n];
            for (int i=0;i<n;i++){
                a[i]=shoppingCart.get(i).getPrice();
            }
            Arrays.sort(a);
            for (int i=0;i<n;i++){
                if (s.size()==0){break;}
                for (int j=0;j<s.size();j++){
                    if (a[i]==s.get(j).getPrice()){
                            System.out.println(s.get(j));
                            s.remove(j);
                            break;
                        }
                    }
                }
            } else if (sortMethod==SortBy.Rating) {
            ArrayList<Product> s=new ArrayList<>();
            int y=this.shoppingCart.size();
            for (int i=0;i<y;i++){
                s.add(shoppingCart.get(i));
            }
            float[]a=new float[n];
            for (int i=0;i<n;i++){
                a[i]=shoppingCart.get(i).getAvgRating();
            }
            Arrays.sort(a);
            for (int i=0;i<n;i++){
                if (s.size()==0){break;}
                for (int j=0;j<s.size();j++){
                    if (a[i]==s.get(j).getAvgRating()){
                        System.out.println(s.get(j));
                        s.remove(j);
                        break;
                    }
                }
            }

        }
    }
    public boolean refundProduct(Product product) {
        boolean a = false;
        Store store=s.get(product);
        if (shoppingCart.contains(product)) {
                a = true;
                shoppingCart.remove(product);
                wallet += product.getPrice();
                store.transact(product,1);
        }

       return a;
    }
}








