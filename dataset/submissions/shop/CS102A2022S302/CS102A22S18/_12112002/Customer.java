import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Customer {
    private static int cnt = 0;//initial is 0 increase by 1 when the constructor is called
    private int id;//unique for each customer and the value is set to cnt
    private String name;
    private float wallet;
    private ArrayList<Product> shoppingCart;
    private ArrayList<Store> storeArrayList;


    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        this.storeArrayList = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else {
            return false;
        }

    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }


    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && this.wallet >= product.getPrice()) {
            updateWallet(-product.getPrice());
            store.transact(product, 0);
            this.shoppingCart.add(product);
            this.storeArrayList.add(store);
            return true;
        } else {
            return false;
        }

    }

    public boolean refundProduct(Product product) {
        int num = 0;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId() == product.getId()) {
                num = i;
                if (!storeArrayList.get(num).hasbuybuydePro(product)) {
                    return false;
                } else {
                    updateWallet(product.getPrice());
                    this.shoppingCart.remove(product);

                    storeArrayList.get(num).transact(product, 1);
                    this.storeArrayList.remove(storeArrayList.get(num));

                    return true;
                }
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.println(this.shoppingCart.get(i).toString());
            }
            //the following is a Overrided comparator
        }
        if (sortMethod == SortBy.Price) {
            ArrayList<Product> copy = new ArrayList<>();
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                copy.add(this.shoppingCart.get(i));
            }
            Collections.sort(copy);



            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.println(copy.get(i).toString());
            }


            //the following is a Overrided comparator
        }
        if (sortMethod == SortBy.Rating) {
            ArrayList<Product> copy = new ArrayList<>();
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                copy.add(this.shoppingCart.get(i));
            }


           Collections.sort(copy, new Comparator<Product>() {
               @Override
               public int compare(Product p1, Product p2) {
                   if (p1.getAvgRating()>p2.getAvgRating()){
                       return 1;
                   }else if (p1.getAvgRating()==p2.getAvgRating()){
                       return 0;
                   }else {
                       return -1;
                   }
               }
           });

            for (int i = 0; i < this.shoppingCart.size(); i++) {
                System.out.println(copy.get(i).toString());
            }
        }
    }

}











