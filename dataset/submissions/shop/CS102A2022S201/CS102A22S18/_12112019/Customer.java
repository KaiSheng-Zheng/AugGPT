


import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt = 0;
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart;

    private float wallet;

    public Customer(String name, float wallet) {
        this.id = 1 + cnt++;
        this.wallet = wallet;
        this.name = name;

        this.shoppingCart = new ArrayList<>(0);

    }

    public boolean rateProduct(Product product, int rating) {
        if (rating > 5 || rating < 1) {
            return false;
        } else {
            product.setRating(rating);
            return true;
        }
    }

    public void updateWallet(float amount) {
        this.wallet = this.wallet + amount;
    }


    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() < wallet) {

            store.removeProduct(product);
            this.shoppingCart.add(product);

            this.wallet = this.wallet - product.getPrice();
            store.setIncome(product.getPrice());
            return true;
        } else return false;
    }

    public void viewShoppingCart(SortBy sortMethod) {
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
            } for (int i = 1; i < shoppingCart.size(); i++) {
                for (int j = 0; j < shoppingCart.size() - i; j++) {
                    {
                        if (this.shoppingCart.indexOf(shoppingCart.get(j)) > this.shoppingCart.indexOf(shoppingCart.get(j + 1))) {
                            Collections.swap(shoppingCart, j, j + 1);

                        }
                    }

                }}
            this.shoppingCart = shoppingCart;
        }
        for (int i=0;i<shoppingCart.size();i++){
            System.out.println(this.shoppingCart.get(i));
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            wallet = wallet + product.getPrice();

            return true;
        } else return false;
    }
}


