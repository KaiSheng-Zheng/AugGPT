import java.util.ArrayList;
public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private ArrayList<Store> shoppingStore=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if(rating>=1 && rating<=5) {
            product.setRating(rating);
            return true;
        }else
            return false;
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(wallet>= product.getPrice() && store.hasProduct(product)){
            updateWallet(-1*product.getPrice());
            shoppingCart.add(product);
            shoppingStore.add(store);
            store.transact(product,0);
            return true;
        }else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        int l=shoppingCart.size(),tt;
        float t;
        float[] f=new float[l];
        int[] s=new int[l];
        if(sortMethod==SortBy.PurchaseTime)
            for(int i=0;i<l;i++) System.out.println(shoppingCart.get(i));
        else if(sortMethod==SortBy.Rating){
            for(int i=0;i<l;i++) {
                f[i]=shoppingCart.get(i).getAvgRating();
                s[i]=i;
            }
            for(int i=0;i<l-1;i++){
                for(int j=0;j<l-1-i;j++){
                    if(f[j]>f[j+1]){
                        t=f[j];f[j]=f[j+1];f[j+1]=t;
                        tt=s[j];s[j]=s[j+1];s[j+1]=tt;
                    } else if(f[j]==f[j+1])
                        if(s[j]>s[j+1]){
                            t=f[j];f[j]=f[j+1];f[j+1]=t;
                            tt=s[j];s[j]=s[j+1];s[j+1]=tt;
                        }
                }
            }
            for(int i=0;i<l;i++) System.out.println(shoppingCart.get(s[i]));
        }else if(sortMethod==SortBy.Price){
            for (int i = 0; i < l; i++) {
                f[i] = shoppingCart.get(i).getPrice();
                s[i] = i;
            }
            for(int i=0;i<l-1;i++){
                for(int j=0;j<l-1-i;j++){
                    if(f[j]>f[j+1]){
                        t=f[j];f[j]=f[j+1];f[j+1]=t;
                        tt=s[j];s[j]=s[j+1];s[j+1]=tt;
                    } else if(f[j]==f[j+1])
                        if(s[j]>s[j+1]){
                            t=f[j];f[j]=f[j+1];f[j+1]=t;
                            tt=s[j];s[j]=s[j+1];s[j+1]=tt;
                        }
                }
            }
            for (int i = 0; i < l; i++) System.out.println(shoppingCart.get(s[i]));
        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            int n=shoppingCart.indexOf(product);
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            shoppingStore.get(n).transact(product,1);
            shoppingStore.remove(n);
            return true;
        }else
            return false;
    }
}


