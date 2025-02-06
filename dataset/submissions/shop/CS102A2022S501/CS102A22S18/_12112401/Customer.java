import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product)) {
            if (wallet >= product.getPrice()) {
                wallet = wallet - product.getPrice();
                shoppingCart.add(product);
                store.transact(product, 0);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
//    public String toString(){
//        ArrayList<Product> input = new ArrayList<>();
//        for (Product i : shoppingCart){
//            input.add(i);
//        }
//        return String.format(input,)
//    }
    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.Price) {
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                for (int j = i + 1; j < shoppingCart.size() - 1 - i; j++) {
                    if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice())
                        Collections.swap(shoppingCart, j, j + 1);
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                for (int j = i + 1; j < shoppingCart.size() - 1 - i; j++) {
                    if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice())
                        Collections.swap(shoppingCart, j, j + 1);
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        } else if (sortMethod == SortBy.Rating) {
            for (int i = 0; i < shoppingCart.size() - 1; i++) {
                for (int j = i + 1; j < shoppingCart.size() - 1 - i; j++) {
                    if (shoppingCart.get(j).getPrice() > shoppingCart.get(j + 1).getPrice())
                        Collections.swap(shoppingCart, j, j + 1);
                }
            }
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
    }
        public boolean refundProduct (Product product){
            return false;
        }
    }