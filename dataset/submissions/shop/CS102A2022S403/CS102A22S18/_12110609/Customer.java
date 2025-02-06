import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (!store.hasProduct(product)){
            return false;
        }

        else if (this.wallet<product.getPrice()){
            return false;
        }
        else {product.setStore(store);
            this.wallet-=product.getPrice();
           shoppingCart.add(product);
            store.transact(product,0);

            return true;}
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
         if (sortMethod.equals(SortBy.Rating)){
//            shoppingCart.sort(Comparator.comparing(Product::getAvgRating));
//            for (Product product : shoppingCart) {
//                System.out.println(product);
//            }
             float[] copy1=new float[shoppingCart.size()];
             for(int i=0;i<shoppingCart.size();i++){
                 copy1[i]=shoppingCart.get(i).getAvgRating();
             }
             float[] copy=new float[shoppingCart.size()];
             for(int i=0;i<shoppingCart.size();i++){
                 copy[i]=shoppingCart.get(i).getAvgRating();
             }
             Arrays.sort(copy);
             for(int i=0;i<shoppingCart.size();i++){
                 for(int j=0;j<shoppingCart.size();j++){
                     if(copy[i]==copy1[j]){
                         System.out.println(shoppingCart.get(j).toString());
                         copy1[j]=100000;
                     }
                 }
             }
        }
         if (sortMethod.equals(SortBy.Price)){
//            shoppingCart.sort(Comparator.comparing(Product::getPrice));
//            for (Product product : shoppingCart) {
//                System.out.println(product);
//            }
             float[] copy1=new float[shoppingCart.size()];
             for(int i=0;i<shoppingCart.size();i++){
                 copy1[i]=shoppingCart.get(i).getPrice();
             }
             float[] copy=new float[shoppingCart.size()];
             for(int i=0;i<shoppingCart.size();i++){
                 copy[i]=shoppingCart.get(i).getPrice();
             }
             Arrays.sort(copy);
             for(int i=0;i<shoppingCart.size();i++){
                 for(int j=0;j<shoppingCart.size();j++){
                     if(copy[i]==copy1[j]){
                         System.out.println(shoppingCart.get(j).toString());
                         copy1[j]=100000;
                     }
                 }
             }}
    }
    public boolean refundProduct(Product product){
        if (!shoppingCart.contains(product)) {
            return  false;
        }
        else { shoppingCart.remove(product);

            wallet+= product.getPrice();
            product.getStore().transact(product,1);

            return true;
        }

        }

    }

