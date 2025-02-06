import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(1); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating <= 5 && rating >= 1) {
            product.setRating(rating);
        }
        return rating <= 5 && rating >= 1;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().size() > 0) {
            if (store.hasProduct(product) && wallet >= product.getPrice()) {
                shoppingCart.add(product);
                wallet -= product.getPrice();
                store.transact(product,0);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> middle = new ArrayList<>(shoppingCart);
            if (sortMethod.equals(SortBy.Price)) {
                for (int i = 0; i < middle.size(); i++) {
                    for (int j = i + 1; j < middle.size(); j++) {
                        if (middle.get(i).getPrice() > middle.get(j).getPrice()) {//if left bigger,exchange;
                            Collections.swap(middle, i, j);
                        }else if (middle.get(i).getPrice() == middle.get(j).getPrice()){
                            int a = 0,b = 0;
                            for (int k = 0;k<shoppingCart.size();k++){
                                if (shoppingCart.get(k).equals(middle.get(i))){
                                    a = k;
                                }
                                if (shoppingCart.get(k).equals(middle.get(j))){
                                    b = k;
                                }
                            }
                            if (a>b){
                                Collections.swap(middle, i, j);
                            }
                        }
                    }
                }

                for (Product product : middle) {
                    System.out.println(product.toString());
                }
            } else if (sortMethod.equals(SortBy.Rating)) {
                for (int i = 0; i < middle.size(); i++) {
                    for (int j = i + 1; j < middle.size(); j++) {
                        if (middle.get(i).getAvgRating() > middle.get(j).getAvgRating()) {//if left bigger,exchange;
                            Collections.swap(middle, i, j);
                        }else if (middle.get(i).getAvgRating() == middle.get(j).getAvgRating()){
                            int a = 0,b = 0;
                            for (int k = 0;k<shoppingCart.size();k++){
                                if (shoppingCart.get(k).equals(middle.get(i))){
                                    a = k;
                                }
                                if (shoppingCart.get(k).equals(middle.get(j))){
                                    b = k;
                                }
                            }
                            if (a>b){
                                Collections.swap(middle, i, j);
                            }
                        }
                    }
                }

                for (Product product : middle) {
                    System.out.println(product.toString());
                }
            } else if (sortMethod.equals(SortBy.PurchaseTime)) {
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
            }
        }


    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)){

        }
     return false;

    }

}