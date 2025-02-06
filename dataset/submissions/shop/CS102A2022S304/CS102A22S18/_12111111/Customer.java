
import java.util.*;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private HashMap<Product,Store> hashMap=new HashMap<>();


    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        shoppingCart=new ArrayList<>();
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet=wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(wallet-product.getPrice()>=0 && store.hasProduct(product)){
            wallet=wallet-product.getPrice();
            store.transact(product,0);
            shoppingCart.add(product);
            hashMap.put(product,store);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        if(sortMethod.getMethod().equals("PurchaseTime")){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        else if(sortMethod.getMethod().equals("Rating")){
            ArrayList<Product> tempShoppingCart=new ArrayList<>(shoppingCart);
            tempShoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getAvgRating()>=o2.getAvgRating()) return 1;
                    else return -1;
                }
            });
            for (int i = 0; i < tempShoppingCart.size(); i++) {
                System.out.println(tempShoppingCart.get(i).toString());
            }
        }
        else {
            ArrayList<Product> tempShoppingCart=new ArrayList<>(shoppingCart);
            tempShoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if(o1.getPrice()>=o2.getPrice()) return 1;
                    else return -1;
                }
            });
            for (int i = 0; i < tempShoppingCart.size(); i++) {
                System.out.println(tempShoppingCart.get(i).toString());
            }
        }
//        else if(sortMethod.getMethod().equals("Rating")){
//            HashMap < Float,String> result=new HashMap<>();
//            for (int i = 0; i < shoppingCart.size(); i++) {
//                result.put(shoppingCart.get(i).getAvgRating(),shoppingCart.get(i).toString());
//            }
//            TreeMap<Float, String> sortedResult = new TreeMap<>(result);
//            for (int i = 0; i < sortedResult.size(); i++) {
//                System.out.println(sortedResult.get(i));//change sequence?
//            }
//        }
//        else {
//            HashMap < Float,String> result=new HashMap<>();
//            for (int i = 0; i < shoppingCart.size(); i++) {
//                result.put(shoppingCart.get(i).getPrice(),shoppingCart.get(i).toString());
//            }
//            TreeMap<Float, String> sortedResult = new TreeMap<>(result);
//            for (int i = 0; i < sortedResult.size(); i++) {
//                System.out.println(sortedResult.get(i));//change sequence?
//            }
//        }
    }
    public boolean refundProduct(Product product){
        if(shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet=wallet+product.getPrice();
            hashMap.get(product).transact(product,1);
            return true;
        }
        else return false;
    }
}


