import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private HashMap<Integer,Store> purchaseFrom;

    public Customer(String name, float wallet){
        id=++cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
        this.purchaseFrom=new HashMap<>();
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&product.getPrice()<=wallet){
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            purchaseFrom.put(product.getID(),store);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case Price:{
                Product[] goods=new Product[shoppingCart.size()];
                for(int i=0;i<shoppingCart.size();i++){
                    goods[i]=shoppingCart.get(i);
                }
                Arrays.sort(goods,new SortByPrice());
                for(int i=0;i<goods.length;i++){
                    System.out.println(goods[i].toString());
                }
                break;
            }
            case Rating:{

                Product[] goods=new Product[shoppingCart.size()];
                for(int i=0;i<shoppingCart.size();i++){
                    goods[i]=shoppingCart.get(i);
                }
                Arrays.sort(goods,new SortByRating());
                for(int i=0;i<goods.length;i++){
                    System.out.println(goods[i].toString());
                }
                break;

            }
            case PurchaseTime:{
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            }
        }
    }
    private class SortByRating implements Comparator<Product>{
        @Override
        public int compare(Product p1,Product p2){
            if(p1.getAvgRating()>= p2.getAvgRating()){
                return 1;
            }
            return -1;
        }
    }
    private class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product p1,Product p2){
            if(p1.getPrice()>= p2.getPrice()){
                return 1;
            }
            return -1;
        }
    }


    public boolean refundProduct(Product product){
        return true;

    }
}

