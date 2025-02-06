import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products;default is empty.
    private float wallet;
    private ArrayList<Store> refundUse=new ArrayList<>();

    public Customer(String name, float wallet) {
        cnt++;
        id=cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int  rating){
        if (product.setRating(rating)){
            return true;
        }else return false;
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
         if (store.hasProduct(product)&&wallet>=product.getPrice()){
                 store.transact(product,0);
                 refundUse.add(store);
                 wallet -=product.getPrice();
                 shoppingCart.add(product);
                 return true;
         }else return false;
    }


    public void viewShoppingCart(SortBy sortMethod){
        for (Product I:shoppingCart){
             System.out.println(I);}
//        switch (sortMethod){
//            case PurchaseTime:
//            {
//                for (Product I:shoppingCart){
//                System.out.println(I);}
//            }
//                break;
//            case Rating:
//            {
//                ArrayList<Product> copy=new ArrayList<Product>();
//                Collections.copy(copy, shoppingCart);
//                Collections.sort(copy, new Comparator<Product>(){
//                    @Override
//                    public int compare(Product o1, Product o2) {
//                        return Float.compare(o1.getAvgRating() , o2.getAvgRating());
//                        //return Float.compare(o2.getAvgRating() , o1.getAvgRating()); 
//                    }
//                });
//                for (Product I:copy){
//                    System.out.println(I);}
//            }
//                break;
//            default:
//                ArrayList<Product> copy=new ArrayList<Product>();
//                Collections.copy(copy, shoppingCart);
//                Collections.sort(copy, new Comparator<Product>(){
//                    @Override
//                    public int compare(Product o1, Product o2) {
//                        return Float.compare(o1.getPrice() , o2.getPrice());
//                        //return Float.compare(o2.getAvgRating() , o1.getAvgRating()); 
//                    }
//                });
//                for (Product I:copy){
//                    System.out.println(I);}
//                break;
        }

    public boolean refundProduct(Product product){
        for (int i=0;i<shoppingCart.size();i++){
            if (product==shoppingCart.get(i)){
                refundUse.get(i).transact(product,1);
                wallet += shoppingCart.get(i).getPrice();
                shoppingCart.remove(i);
                refundUse.remove(i);
                return true;
            }
        }
        return false;
    }

}
