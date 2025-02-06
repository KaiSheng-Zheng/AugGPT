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
        if ((rating>=1)&&(rating<=5)){
            product.getRatings().add(rating);
            return true;}
        else return false;
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if ((store.hasProduct(product))&&(this.wallet>=product.getPrice())){
            this.shoppingCart.add(product);
            this.wallet-=product.getPrice();
            store.removeProduct(product);
            float c=store.getIncome()+product.getPrice();
            store.setIncome(c);
            return true;
        } else   return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        if (sortMethod.equals(SortBy.PurchaseTime)){
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }else if (sortMethod.equals(SortBy.Price)){
           shoppingCart.sort(new Comparator<Product>() {
               @Override
               public int compare(Product o1, Product o2) {
                   return (int) (o1.getPrice()-o2.getPrice());
               }
           });
            for (Product product : shoppingCart) {
                System.out.println(product.toString());
            }
        }else if (sortMethod.equals(SortBy.Rating)){
           shoppingCart.sort(new Comparator<Product>() {
               @Override
               public int compare(Product o1, Product o2) {
                   return Float.compare(o1.getAvgRating(),o2.getAvgRating());
               }
           });
           for (Product product : shoppingCart){
               System.out.println(product.toString());
           }
    }

    }
    public boolean refundProduct(Product product){
        return false;
}}
