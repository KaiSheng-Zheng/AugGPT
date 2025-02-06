import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product>shoppingCart= new ArrayList<>();
    private float wallet;
    static ArrayList<Store> A = new ArrayList<>();
    static ArrayList<Product> B = new ArrayList<>();

    public Customer(String nmae,float wallet){
        cnt++;
        this.id=cnt;
        this.name=nmae;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product,int rating){
        if (rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }
        else return false;
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        if (store.getProductList().contains(product)&&product.getPrice()<=wallet){
            shoppingCart.add(product);
            wallet=wallet-product.getPrice();
            store.transact(product,0);
            A.add(store);
            B.add(product);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> a = new ArrayList<>(shoppingCart);
        if (sortMethod==SortBy.PurchaseTime){
            for (Product product : a) {
                System.out.println(product.toString());
            }
        }
        else if (sortMethod==SortBy.Rating){
            ArrayList<Product> n=new ArrayList<>();
            int m=a.size();
            for (int i=0;i<m;i++){
                int num=0;
                Product k=a.get(0);
                for (int j=0;j<a.size();j++){
                    if (k.getAvgRating()>a.get(j).getAvgRating()){
                        k=a.get(j);
                        num=j;
                    }
                }
                n.add(a.get(num));
                a.remove(a.get(num));
            }
            for (int i=0;i<n.size();i++){
                System.out.println(n.get(i).toString());
            }
        }
        else if (sortMethod==SortBy.Price){
            ArrayList<Product> n=new ArrayList<>();
            int m=a.size();
            for (int i=0;i<m;i++){
                int num=0;
                Product k=a.get(0);
                for (int j=0;j<a.size();j++){
                    if (k.getPrice()>a.get(j).getPrice()){
                        k=a.get(j);
                        num=j;
                    }
                }
                n.add(a.get(num));
                a.remove(a.get(num));
            }
            for (int i=0;i<n.size();i++){
                System.out.println(n.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet=wallet+ product.getPrice();
            A.get(B.indexOf(product)).transact(product,1);
            return true;
        }
        else return false;
    }


}
