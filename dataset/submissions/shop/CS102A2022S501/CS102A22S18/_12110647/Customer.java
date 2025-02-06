import java.util.ArrayList;
import java.util.Arrays;

public class Customer<SortBy> {
    public static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public Customer(String name, float wallet){//first customer 1,always valid
        id=cnt;
    }

    public boolean rateProduct(Product product,int rating){//rating by customer
        if(rating >5||rating <1){
            return false;
        }else {
            return true;
        }
    }
    public void updateWallet(float amount){
        this.wallet=wallet;
    }
    public boolean purchaseProduct(Store store,Product product) {//judge if product is contained
        shoppingCart.indexOf(-1);
        float price=product.getPrice();
        String productArrayList=product.getProductArrayList();
        if (productArrayList.contains((CharSequence) product)||wallet <price) {//price valid
            return true;
        } else {
            return false;
        }
    }
    public void viewShoppingCart(OnlineShopping.SortBy sortMethod) {
        switch(sortMethod){
            case PurchaseTime:
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            case Rating:
                ArrayList<Integer> rate;
                return;
                }

        }
    }
