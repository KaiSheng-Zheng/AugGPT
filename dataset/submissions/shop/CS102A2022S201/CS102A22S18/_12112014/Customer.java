import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 1;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>(0);
        this.id = cnt++;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating >= 1 && rating <= 5) {
            product.setRating(rating);
            return true;
        } else {
            return false;
        }
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && product.getPrice() <= wallet){
            wallet -= product.getPrice();
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCart = this.shoppingCart;
        if (sortMethod == SortBy.Price) {
            for (int i = 1; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size() - i; j++) {
                    if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice()) {
                        Collections.swap(shoppingCart, j, j + 1);
                    } else if (shoppingCart.get(j).getPrice() == shoppingCart.get(j + 1).getPrice()) {
                        if (this.shoppingCart.indexOf(shoppingCart.get(j)) > this.shoppingCart.indexOf(shoppingCart.get(j + 1))) {
                            Collections.swap(shoppingCart, j, j + 1);

                        }
                    }
                }
            }
            this.shoppingCart = shoppingCart;
        }
        if (sortMethod == SortBy.PurchaseTime) { {
            for (int i = 1; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size() - i; j++) {
                    {
                        if (this.shoppingCart.indexOf(shoppingCart.get(j)) > this.shoppingCart.indexOf(shoppingCart.get(j + 1))) {
                            Collections.swap(shoppingCart, j, j + 1);

                        }
                    }

                }}
            this.shoppingCart = shoppingCart;
        }

        }
        if (sortMethod == SortBy.Rating) {
            for (int i = 1; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size() - i; j++) {
                    if (shoppingCart.get(j).getAvgRating() > shoppingCart.get(j + 1).getAvgRating()) {
                        Collections.swap(shoppingCart, j, j + 1);
                    } else if (shoppingCart.get(j).getAvgRating() == shoppingCart.get(j + 1).getAvgRating()) {
                        if (this.shoppingCart.indexOf(shoppingCart.get(j)) > this.shoppingCart.indexOf(shoppingCart.get(j + 1))) {
                            Collections.swap(shoppingCart, j, j + 1);

                        }
                    }

                }
            } this.shoppingCart = shoppingCart;
        }
        for (int i=0;i<shoppingCart.size();i++){
            System.out.println(this.shoppingCart.get(i));
        }
    }
}
