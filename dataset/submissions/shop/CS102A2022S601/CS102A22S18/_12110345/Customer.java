import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Integer,Store> findstore=new HashMap<>();
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
    }
    public boolean rateProduct(Product product,int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&wallet>=product.getPrice()){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
          return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:{
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
            }break;
            }
            case Rating:{
                Product[] a=new Product[shoppingCart.size()];
                for(int i=0;i<shoppingCart.size();i++){
                    a[i]=shoppingCart.get(i);
                }
                Arrays.sort(a,new Sortrating());
                for(int i=0;i<a.length;i++){
                    System.out.println(a[i].toString());
                }break;
            }
            case Price:{
                Product[] a=new Product[shoppingCart.size()];
                for(int i=0;i<shoppingCart.size();i++){
                    a[i]=shoppingCart.get(i);
                }
                Arrays.sort(a,new Sortprice());
                for(int i=0;i<a.length;i++){
                    System.out.println(a[i].toString());
                }break;
            }
        }
    }
    public boolean refundProduct(Product product){
        int t=0;
        for(int i=0;i<Store.allproductList.size();i++){
            if(Store.allproductList.get(i).getID()==product.getID()){
                t++;
            }
        }
        if(t==1){
            Store store=findstore.get(product.getID());
            store.transact(product,1);
            shoppingCart.remove(shoppingCart.indexOf(product));
            updateWallet(product.getPrice());
            findstore.remove(product.getID());
            return true;
        }
        return false;
    }

    
    private class Sortrating implements Comparator<Product> {
        @Override
        public int compare(Product product1,Product product2){
            if(product1.getAvgRating()>=product2.getAvgRating()){
                return 1;
            }else{
                return -1;
            }
        }
    }
    private class Sortprice implements Comparator<Product> {
        @Override
        public int compare(Product product1,Product product2){
            if(product1.getPrice()>=product2.getPrice()){
                return 1;
            }else{
                return -1;
            }
        }
    }

}

