
import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;


    }

    public boolean rateProduct(Product product, int rating) {
        switch (rating) {
            case 1:
                product.setRating(rating);
                return true;
            case 2:
                product.setRating(rating);
                return true;
            case 3:
                product.setRating(rating);
                return true;
            case 4:
                product.setRating(rating);
                return true;
            case 5:
                product.setRating(rating);
                return true;
            default:
                return false;
        }

    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }//??

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && (wallet >= product.getPrice())) {
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (shoppingCart.size() != 0) {
            if (sortMethod.equals(SortBy.PurchaseTime)) {
                viewByPurchaseTime();
            }
            if (sortMethod.equals(SortBy.Rating)) {
                viewByRating();
            }
            if (sortMethod.equals(SortBy.Price)) {
                viewByPrice();
            }
        }


    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.size() != 0) {
            if (shoppingCart.contains(product)) {

                if (product.from == null) {
                    ;return false;
                } else {
                    product.from.transact(product, 1);
                    shoppingCart.remove(product);
                    updateWallet(product.getPrice());
                    return true;
                }
            } else {
                return false;

        }}else {
    return false;}}


        ;

        public void viewByPurchaseTime () {
            for (Product i : shoppingCart) {
                System.out.println(i.toString());
            }

        }

        public void viewByRating () {
            if (shoppingCart.size() != 0) {
                int[] sort1 = new int[shoppingCart.size()];

                for (int i = 0; i < shoppingCart.size(); i++) {
                    sort1[i] = ((int) (100 * shoppingCart.get(i).getAvgRating()));
                }
                Arrays.sort(sort1);
                for (int i : sort1) {
                    for (Product t : shoppingCart) {
                        if ((int) (t.getAvgRating() * 100) == i) {
                            System.out.println(t.toString());
                        }
                    }
                }
            }


        }

        public void viewByPrice () {
            int[] sort1 = new int[shoppingCart.size()];
            for (int i = 0; i < shoppingCart.size(); i++) {
                sort1[i] = ((int) (100 * shoppingCart.get(i).getPrice()));
            }
            Arrays.sort(sort1);
            for (int i : sort1) {
                for (Product t : shoppingCart) {
                    if ((int) (t.getPrice() * 100) == i) {
                        System.out.println(t.toString());
                    }
                }
            }


        }

    }
