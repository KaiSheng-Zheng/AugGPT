import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    public ArrayList<Store> storeList=new ArrayList<>();
    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.id = cnt;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<Product>();
    }

    public boolean rateProduct(Product product, int rating) {

        return product.setRating(rating);

    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            this.shoppingCart.add(product);
            storeList.add(store);
            this.wallet -= product.getPrice();
            return true;
        } else return false;

    }


    public ArrayList<Product> getMin(ArrayList<Product> x) {
        float minPrice = x.get(0).getPrice();
        int cnt = 0;
        ArrayList<Product> result = new ArrayList<Product>();
        for (int j = 0; j < result.size(); j++) {


            for (int i = 0; i < x.size(); i++) {
                if (minPrice < x.get(i).getPrice()) {
                    minPrice = x.get(i).getPrice();
                    cnt = i;
                }
            }
            result.add(x.get(cnt));
            x.remove(cnt);
        }
        return result;
    }
    public ArrayList<Product> getMin1(ArrayList<Product> x) {
        float minRating = x.get(0).getPrice();
        int cnt = 0;
        ArrayList<Product> result = new ArrayList<Product>();
        for (int j = 0; j < result.size(); j++) {


            for (int i = 0; i < x.size(); i++) {
                if (minRating < x.get(i).getAvgRating()) {
                    minRating = x.get(i).getAvgRating();
                    cnt = i;
                }
            }
            result.add(x.get(cnt));
            x.remove(cnt);
        }
        return result;
    }

        public void viewShoppingCart(SortBy sortMethod) {
            if (sortMethod == SortBy.PurchaseTime) {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            } else if (sortMethod == SortBy.Rating) {
                Collections.sort(shoppingCart, new Comparator<Product>() {
                    public int compare(Product a1, Product a2) {
                        if (a1.getAvgRating() - a2.getAvgRating() >= 0) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                });
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            } else if (sortMethod == SortBy.Price) {
                Collections.sort(shoppingCart, new Comparator<Product>() {
                    public int compare(Product a1, Product a2) {
                        if (a1.getPrice() - a2.getPrice() >= 0) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                });
                for (int i = 0; i < shoppingCart.size(); i++) {
                    System.out.println(shoppingCart.get(i).toString());
                }
            }
        }



    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)) {
            this.wallet+=product.getPrice();
            shoppingCart.remove(product);
            storeList.get(shoppingCart.indexOf(product)).transact(product,1);
return true;
        }else{
            return false;
        }
    }
}
