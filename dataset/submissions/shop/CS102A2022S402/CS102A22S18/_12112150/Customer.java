import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;



    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public Customer(String name, float wallet){
       shoppingCart=new ArrayList<>();
        cnt++;
        this.name = name;
        this.wallet=wallet;

        id=cnt;
    }

    public boolean rateProduct(Product product, int rating){
        if (product.setRating(rating))
            return true;
        else
            return false;
    }

    public void updateWallet(float amount) {

        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
       int  n  = 0;
        if (store.hasProduct(product)&&wallet>= product.getPrice()){
            updateWallet(-product.getPrice());
            getShoppingCart().add(product);
            store.transact(product,0);
            Store[]stores = new Store[30];
            Product[]products=new Product[30];
            n++;
            stores[n]=store;
            products[n]=product;
            return true;}
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod==SortBy.Price){
      Collections.sort(getShoppingCart(), new Comparator<Product>() {
          @Override
          public int compare(Product o1, Product o2) {
              int flag;
              flag= (int) (o1.getPrice()-o2.getPrice());
              return flag;
          }
      });
      for (int i = 0;i<getShoppingCart().size();i++){
            System.out.println(getShoppingCart().get(i));
            }}

        if (sortMethod==SortBy.Rating){
            Collections.sort(getShoppingCart(), new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    int flage;
                    flage =(int)((o1.getAvgRating()-o2.getAvgRating())*1000);
                    if (flage==0)
                        flage= shoppingCart.indexOf(o1)-shoppingCart.indexOf(o2);
                    return flage;
                }
            });
            for (int i = 0;i<getShoppingCart().size();i++){
                System.out.println(getShoppingCart().get(i));
                }
        }
if (sortMethod==SortBy.PurchaseTime){
     Collections.sort(getShoppingCart(), new Comparator<Product>() {
         @Override
         public int compare(Product o1, Product o2) {
            int in;
            in = shoppingCart.indexOf(o1)-shoppingCart.indexOf(o2);
             return in;
         }
     });
    for (int i = 0;i<getShoppingCart().size();i++){
        System.out.println(getShoppingCart().get(i));
        }
}


    }
    public  boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            updateWallet(product.getPrice());
            shoppingCart.remove(product);

            return true;
        }
        else
            return false;
    }




}
