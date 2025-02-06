import javax.print.attribute.standard.PDLOverrideSupported;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> sst=new ArrayList<>();
    public ArrayList<Product> ppt=new ArrayList<>();
    public Customer(String name,float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
        this.shoppingCart=new ArrayList<Product>();
    }
    public boolean rateProduct(Product product,int rating){
        if (rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }
        else {
            return false;
        }
    }

    public void updateWallet(float amount){
        this.wallet=this.wallet+amount;
    }
    public boolean purchaseProduct(Store store,Product product){
        if (store.hasProduct(product)){
            if (wallet>=product.getPrice()){
                sst.add(store);
                ppt.add(product);
                updateWallet(-product.getPrice());
                store.transact(product,0);
                shoppingCart.add(product);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> newShop=new ArrayList<>(shoppingCart);
        if (sortMethod==SortBy.PurchaseTime){
            for(int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if (sortMethod==SortBy.Rating){
            Collections.sort(newShop,new RatingComparator());
            for (int i=0;i<newShop.size();i++){
                System.out.println(newShop.get(i).toString());
            }
        }
        else if (sortMethod==SortBy.Price){
            Collections.sort(newShop,new PriceComparator());
            for (int i=0;i<newShop.size();i++){
                System.out.println(newShop.get(i).toString());
            }
        }
    }
    public boolean refundProduct(Product product){
        int storeNum=0;
        int counter=0;
        int c1=0;

        for (int i=0;i<shoppingCart.size();i++){
            if (product.getId()==shoppingCart.get(i).getId()){
                c1++;
            }
        } if (c1==0){
            return false;
        }
        else {
            for(int i=0;i<ppt.size();i++){
                if (ppt.get(i).getId()==product.getId()){
                    storeNum++;
                    storeNum=i;
                    break;
                }
            }
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            sst.get(storeNum).transact(product,1);
            return true;
        }

    }




}
