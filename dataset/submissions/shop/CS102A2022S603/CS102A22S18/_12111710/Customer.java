import java.util.ArrayList;
import java.util.Comparator;
public class  Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private ArrayList<Store>stores1=new ArrayList<>();
    private ArrayList<Store>stores2=new ArrayList<>();
    public Customer(String name, float wallet)  {
    this.name=name;
    this.wallet=wallet;
    cnt++;
    this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
    return product.setRating(rating);
    }
    public void updateWallet(float amount){
    wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
    if(store.hasProduct(product)==true&&wallet>=product.getPrice()){
        stores1.add(store);
        shoppingCart.add(product);
        store.removeProduct(product);
        updateWallet(-product.getPrice());
        store.transact(product,0);
        stores2.add(store);
        return true;
    }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:{
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
            }
            break;
            case Price:{
                shoppingCart.sort(Comparator.comparing(Product::getPrice));
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
            }break;
            case Rating:
                shoppingCart.sort(Comparator.comparing(Product::getAvgRating));
                for (int i=0;i<shoppingCart.size();i++){
                    System.out.println(shoppingCart.get(i));
                }
        }
    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+=product.getPrice();
           for (int i=0; i<stores1.size();i++){
               if (stores1.get(i).hasProduct(product)){
                   stores2.get(i).transact(product,1);
               }
           }
           return true;
        }
    else {
        return false;
        }
    }
}





