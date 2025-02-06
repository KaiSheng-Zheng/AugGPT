import java.util.*;

public class Customer {
    private static int cnt;
    private int num;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet){
        setCnt(getCnt());
        this.id=getCnt();
        this.name=name;
        this.wallet=wallet;
    }
    public void setCnt(int cnt){this.cnt=cnt+1;}
    public int getCnt(){return cnt;}
    public float getWallet(){
        return wallet;
    }
    public boolean rateProduct(Product product, int rating){
        if(product.setRating(rating)) return true;
        else return false;
    }
    public void updateWallet(float amount){
        this.wallet=getWallet()+amount;
    }
    public void setShoppingCart(Product product){
        shoppingCart.add(product);
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&product.getPrice()<=getWallet()){
            updateWallet(-product.getPrice());
            setShoppingCart(product);
            store.transact(product,0);
            num++;
            product.setNum(num);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        int n=shoppingCart.size();
        Product[] a=new Product[n];
        for(int i=0;i<n;i++)  a[i]=shoppingCart.get(i);
        if(sortMethod.equals(SortBy.Price)) {
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++)
                    if(a[i].getPrice()>a[j].getPrice()|| (a[i].getPrice()==a[j].getPrice()&& a[i].getNum()>a[j].getNum())){
                        Product t=a[i];a[i]=a[j];a[j]=t;
                    }
            }
        }
        else if(sortMethod.equals(SortBy.Rating)){
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++)
                    if(a[i].getAvgRating()>a[j].getAvgRating()|| ((a[i].getAvgRating()-a[j].getAvgRating())<0.0000001&& a[i].getNum()>a[j].getNum())){
                        Product t=a[i];a[i]=a[j];a[j]=t;
                    }
            }
        }
        for(Product p:a) System.out.println(p);
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            product.getStore().transact(product,1);
            num--;
            product.setNum(0);
            return true;
        }
        else return false;
    }
}
