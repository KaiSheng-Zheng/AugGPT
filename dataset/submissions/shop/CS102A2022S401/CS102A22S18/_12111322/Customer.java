import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private ArrayList<Product> sbrating;
    private ArrayList<Product> sbprice;
    private float wallet;
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<Product>();
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(wallet>=product.getPrice()&&store.getProductList().contains(product)){
            store.transact(product,0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;
        }else {
            return false;
        }
    }
    //   public boolean refundProduct(Product product){
//       if(shoppingCart.contains(product)){
//           shoppingCart.remove(product);
//           updateWallet(product.getPrice());
//
//       }
//   }
    public static void sortByRatings(ArrayList<Product> shoppingCart){
        Collections.sort(shoppingCart,  new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getAvgRating()> o2.getAvgRating()){
                    return 1;
                }else if (o1.getAvgRating()== o2.getAvgRating()){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
    }
    public static void sortByPrices(ArrayList<Product> shoppingCart){
        Collections.sort(shoppingCart, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (Product product:shoppingCart){
                    System.out.println(product.toString());
                }
                break;
            case Rating:
                sbrating=(ArrayList<Product>) shoppingCart.clone();
                sortByRatings(sbrating);
                for (Product product:sbrating) {
                    System.out.println(product.toString());

                }break;
            case Price:
                sbprice=(ArrayList<Product>) shoppingCart.clone();
                sortByPrices(sbprice);
                for (Product product:sbprice) {
                    System.out.println(product.toString());

                }break;
        }
    }
}
