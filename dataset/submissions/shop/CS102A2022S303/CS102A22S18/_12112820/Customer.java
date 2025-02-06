import java.util.*;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private HashMap<Integer,Store> purchaseFrom;
    private float wallet; 
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
        switch(sortMethod){
            case PurchaseTime:{
                //System.out.println("!");
                for(int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i).toString());
                }
                break;
            }
            case Rating:{
                Product[] tmp=new Product[shoppingCart.size()];
                for(int i=0;i<shoppingCart.size();i++){
                    tmp[i]=shoppingCart.get(i);
                }
                Arrays.sort(tmp,new SortByRating());
                //System.out.println("!");
                for(int i=0;i<tmp.length;i++){
                    System.out.println(tmp[i].toString());
                }
                break;
            }
            case Price:{
                //System.out.println("!");
                Product[] tmp=new Product[shoppingCart.size()];
                for(int i=0;i<shoppingCart.size();i++){
                    tmp[i]=shoppingCart.get(i);
                }
                Arrays.sort(tmp,new SortByPrice());
                for(int i=0;i<tmp.length;i++){
                    System.out.println(tmp[i].toString());
                }
                break;
            }
        }
    }
    public boolean refundProduct(Product product){
        if(purchaseFrom.containsKey(product.getID())){
            Store store=purchaseFrom.get(product.getID());
            store.transact(product,1);
            shoppingCart.remove(shoppingCart.indexOf(product));
            updateWallet(product.getPrice());   
            purchaseFrom.remove(product.getID());
            return true;
        }
        return false;
    }
    private class SortByRating implements Comparator<Product>{
        @Override
        public int compare(Product p1,Product p2){
            return p2.getAvgRating()<=p1.getAvgRating()?1:-1;
        }
    }
    private class SortByPrice implements Comparator<Product>{
        @Override
        public int compare(Product p1,Product p2){
            return p2.getPrice()<=p1.getPrice()?1:-1;
        }
    }
}
