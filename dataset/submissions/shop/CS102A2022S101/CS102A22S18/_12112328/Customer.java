import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private static int PurchaseTime=0;
    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
         return product.setRating(rating);
    }
    public void updateWallet(float amount){
             wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
              for (Product a:store.getProductList()){
                  if (a.getId()==product.getId()){
                      if (wallet>=product.getPrice()){
                          PurchaseTime++;
                          product.setPurchaseTime(PurchaseTime);
                          product.setStore(store);
                          updateWallet(-product.getPrice());
                          shoppingCart.add(product);
                          store.transact(product,0);
                          return true;
                      }
                  }
              }
              return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
       // shoppingCart.sort(sortMethod);
        shoppingCart.sort ( new Comparator<Product>(){
            @Override
            public int compare(Product arg0 , Product arg1) {
                if (sortMethod== SortBy.PurchaseTime)
                return arg0 .getPurchaseTime()-( arg1.getPurchaseTime());
                if (sortMethod== SortBy.Rating)
                {
                    if (arg0 .getAvgRating()-( arg1.getAvgRating())>0){

                        return 1;

                    }else {
                        if (arg0 .getAvgRating()-( arg1.getAvgRating())<0){return -1;
                        }else{
                            return arg0 .getPurchaseTime()-( arg1.getPurchaseTime());
                        }

                    }
                }

                if (arg0.getPrice()-( arg1.getPrice())>0){
                    return 1;

                }else {
                    if(arg0.getPrice()-( arg1.getPrice())<0) {return -1;}
                else return arg0 .getPurchaseTime()-( arg1.getPurchaseTime());}
            }
        });
        for (Product a:shoppingCart){
            System.out.println(a.toString());
        }

    }
    public boolean refundProduct(Product product){
        for (Product a:shoppingCart){
            if (a.getId()==product.getId()){
                    updateWallet(product.getPrice());
                    shoppingCart.remove(product);
                    product.getStore().transact(product,1);
                    return true;
            }
        }
        return false;

    }

}
