import java.util.ArrayList;

import java.util.Collections;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart=new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        boolean rpt = false;
        if (product.setRating(rating)) {
            rpt = true;
        }
        return rpt;
    }

    public void updateWallet(float amount) {
            this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        boolean pchpdct = false;
        if (store.hasProduct(product) && this.wallet >= product.getPrice()) {
            pchpdct = true;
            product.setFrom(store);
            shoppingCart.add(product);
            wallet=wallet- product.getPrice();
            store.transact(product,0);
        }
        return pchpdct;
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i; j < shoppingCart.size(); j++)
                    if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating()) {
                        Collections.swap(shoppingCart, i, j);
                    }
            }for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getAvgRating() == shoppingCart.get(j).getAvgRating()) {
                        if (shoppingCart.get(i).getId() > shoppingCart.get(j).getId()) {
                            Collections.swap(shoppingCart, i, j);
                        }
                    }
                }

            }for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Price) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice()) {
                        Collections.swap(shoppingCart, i, j);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getPrice() == shoppingCart.get(j).getPrice()) {
                        if (shoppingCart.get(i).getId() > shoppingCart.get(j).getId()) {
                            Collections.swap(shoppingCart, i, j);
                        }
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }

public boolean refundProduct(Product product) {
        boolean rfdpdt=false;
        int counter=0;
        for (int i=0;i<shoppingCart.size();i++ ){
           if (product==shoppingCart.get(i)){
            counter++;
        }
        }
        if (counter==1){
        Store store=product.getfrom();
            rfdpdt=true;
            shoppingCart.remove(product);
            wallet=wallet+ product.getPrice();
           store.transact(product,1);
        }
        return rfdpdt;
    }
}
