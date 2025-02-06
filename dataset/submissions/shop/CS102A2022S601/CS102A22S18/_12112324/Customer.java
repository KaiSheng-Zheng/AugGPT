import java.util.ArrayList;
import java.util.Arrays;
public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>(){};
    private float wallet;
    private ArrayList<Store> stores=new ArrayList<Store>(){};
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name = name;
        this.wallet = wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product) && wallet >= product.getPrice()){
            float a = -product.getPrice();
            updateWallet(a);
            shoppingCart.add(product);
            store.transact(product,0);
            stores.add(store);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod==SortBy.Rating){
            ArrayList<Product> temp = new ArrayList<>(shoppingCart);
            float[] f=new float[shoppingCart.size()];
            for(int i=0;i<f.length;i++){
                f[i]=shoppingCart.get(i).getAvgRating();
            }
            Arrays.sort(f);
            for(int i=0;i<f.length;i++){
                if(temp.get(i).getAvgRating()==f[i]){
                    System.out.println(temp.get(i).toString());
                }else {
                    for(int j=i;j<f.length;j++){
                        if(temp.get(j).getAvgRating()==f[i]){
                            System.out.println(temp.get(j).toString());
                            Product t=temp.get(j);
                            temp.remove(j);
                            temp.add(i,t);
                            break;
                        }
                    }
                }
            }
        }else if(sortMethod==SortBy.PurchaseTime){
            for(int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }else {
            ArrayList<Product> temp = new ArrayList<>(shoppingCart);
            float[] f=new float[shoppingCart.size()];
            for(int i=0;i<f.length;i++){
                f[i]=shoppingCart.get(i).getPrice();
            }
            Arrays.sort(f);
            for(int i=0;i<f.length;i++){
                if(temp.get(i).getPrice()==f[i]){
                    System.out.println(temp.get(i).toString());
                }else {
                    for(int j=i;j<f.length;j++){
                        if(temp.get(j).getPrice()==f[i]){
                            System.out.println(temp.get(j).toString());
                            Product t=temp.get(j);
                            temp.remove(j);
                            temp.add(i,t);
                            break;
                        }
                    }
                }
            }
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            int index=shoppingCart.indexOf(product);
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            stores.get(index).transact(product,1);
            stores.remove(index);
            return true;
        }
        return false;
    }
}