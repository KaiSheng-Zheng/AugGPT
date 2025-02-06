import java.util.ArrayList;
import java.util.Arrays;

public class Customer{
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    private SortBy sortBy;

    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        if (rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        } else return false;
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (wallet>=product.getPrice()&&store.getProductList().contains(product)){
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod==SortBy.PurchaseTime){
            for (Product a : shoppingCart){
                System.out.println(a);
            }
        } else if (sortMethod==SortBy.Rating){
            if (shoppingCart.size()>1) {
                float[] rateList = new float[shoppingCart.size()];
                for (int n = 0; n < shoppingCart.size(); n++) {
                    rateList[n] = shoppingCart.get(n).getAvgRating();
                }
                Arrays.sort(rateList);
                int jj = -1;
                for (int m = 0; m < rateList.length - 1; m++) {
                    if (rateList[m] == rateList[m + 1]) {
                        rateList[m + 1] = jj;
                        jj--;
                    }
                }
                for (float v : rateList) {
                    for (int m = 0; m < rateList.length; m++) {
                        if (v == shoppingCart.get(m).getAvgRating()) {
                            System.out.println(shoppingCart.get(m));
                        }
                    }
                }
            } else if (shoppingCart.size()==1){
                System.out.println(shoppingCart.get(0));
            } else System.out.println(shoppingCart);
        } else if (sortMethod==SortBy.Price){
            if (shoppingCart.size()>1) {
                float[] priceList = new float[shoppingCart.size()];
                for (int n = 0; n < shoppingCart.size(); n++) {
                    priceList[n] = shoppingCart.get(n).getPrice();
                }
                Arrays.sort(priceList);
                int jj = -1;
                for (int m = 0; m < priceList.length - 1; m++) {
                    if (priceList[m] == priceList[m + 1]) {
                        priceList[m + 1] = jj;
                        jj--;
                    }
                }
                for (float v : priceList) {
                    for (int m = 0; m < priceList.length; m++) {
                        if (v == shoppingCart.get(m).getPrice()) {
                            System.out.println(shoppingCart.get(m));
                        }
                    }
                }
            } else if (shoppingCart.size()==1){
                System.out.println(shoppingCart.get(0));
            } else System.out.println(shoppingCart);
        }

    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.getStore().transact(product,1);
            return true;
        } else return false;
    }
}