import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet){
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
        if(store.hasProduct(product)&&wallet>product.getPrice()){
            store.transact(product,0);
            wallet-=product.getPrice();
            shoppingCart.add(product);
            product.buyFrom=store;
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product>origin=new ArrayList<>();
        for (int i=0;i<shoppingCart.size();i++){
            origin.add(shoppingCart.get(i));
        }
        if(sortMethod==SortBy.PurchaseTime){
            for (Product i:shoppingCart){
                System.out.println(i);
            }
        }else if (sortMethod==SortBy.Rating){
            for (int i=0;i<shoppingCart.size()-1;i++){
                for (int j=0;j<shoppingCart.size()-1-i;j++){
                    Product flag;
                    if (shoppingCart.get(j).getAvgRating()>shoppingCart.get(j+1).getAvgRating()) {
                        flag = shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,flag);
                    }
                }
            }
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i));
            }
            shoppingCart=origin;

        } else if (sortMethod==SortBy.Price){
            for (int i=0;i<shoppingCart.size()-1;i++){
                for (int j=0;j<shoppingCart.size()-1-i;j++){
                    Product flag;
                    if (shoppingCart.get(j).getPrice()>shoppingCart.get(j+1).getPrice()) {
                        flag = shoppingCart.get(j);
                        shoppingCart.set(j,shoppingCart.get(j+1));
                        shoppingCart.set(j+1,flag);
                    }
                }
            }
            for (int i=0;i<shoppingCart.size();i++){
                System.out.println(shoppingCart.get(i));
            }
            shoppingCart=origin;
        }
    }

    public boolean refundProduct(Product product){
        if (product.buyFrom!=null){
            product.buyFrom.transact(product,1);
            shoppingCart.remove(product);
            wallet+=product.getPrice();
            return true;
        }
        return false;
    }
}
