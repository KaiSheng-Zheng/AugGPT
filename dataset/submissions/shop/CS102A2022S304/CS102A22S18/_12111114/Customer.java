import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products default is empty.
    private float wallet;
    static Map<Product, Store> stm = new HashMap<>();


    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
        shoppingCart = new ArrayList<>();
//        for (Product product1 : shoppingCart) {
//            money.add(product1.getPrice());
//            rating.add(product1.getAvgRating());
//            money_product.put(product1.getPrice(), product1);
//            rating_product.put(product1.getAvgRating(), product1);
//        }
    }

    //
    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    //
    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    //
    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            addProduct(product);
            store.transact(product, 0);
            stm.put(product, store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        int a = shoppingCart.size();
        ArrayList<Product> shoppingCart_sort = new ArrayList<>(shoppingCart);
        switch (sortMethod) {
            case PurchaseTime:
                for (Product product1 : shoppingCart) {
                    System.out.println(product1.toString());
                }
                break;
            case Rating:
                shoppingCart_sort.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getAvgRating() >= o2.getAvgRating()) {
                            return 1;
                        } else
                            return -1;
                    }
                });
                for (Product product1 : shoppingCart_sort) {
                    System.out.println(product1.toString());
                }
                break;
//                rating.sort(Comparator.naturalOrder());
//                for (int i = 0; i < a; i++) {
//                    Product product1 = rating_product.get(rating.get(i));
//                    System.out.print(product1.toString());
//                }
            case Price:
                shoppingCart_sort.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() >= o2.getPrice()) {
                            return 1;
                        } else
                            return -1;
                    }
                });
                for (Product product1 : shoppingCart_sort) {
                    System.out.println(product1.toString());
                }
                break;
//                money.sort(Comparator.naturalOrder());
//                for (int i = 0; i < a; i++) {
//                    Product product1 = money_product.get(money.get(i));
//                    System.out.print(product1.toString());
//                }
        }
    }

    public boolean refundProduct(Product product) {
        if (removeProduct(product)) {
            stm.get(product).transact(product, 1);
            return true;
        } else return false;
    }

    public boolean hasProduct(Product product) {
        int b = shoppingCart.size();
        for (int i = 0; i < b; i++) {
            if (product.equals(shoppingCart.get(i)))
                return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product))
            return false;
        else {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);

            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            updateWallet(product.getPrice());
            shoppingCart.remove(product);
            return true;
        } else {
            return false;
        }
    }
}
