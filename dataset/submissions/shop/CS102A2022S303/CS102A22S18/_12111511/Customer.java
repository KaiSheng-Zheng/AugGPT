import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt++;
        id = cnt;
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
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            product.setStore(store);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else if (sortMethod == SortBy.Rating) {
//            for (int i = 0; i < shoppingCart1(shoppingCart).size(); i++) {
//                System.out.println(shoppingCart1(shoppingCart).get(i).toString());
//            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i + 1; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getAvgRating() > shoppingCart.get(j).getAvgRating()) {
                        Collections.swap(shoppingCart, i, j);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i + 1; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getAvgRating() == shoppingCart.get(j).getAvgRating() && shoppingCart.get(i).getId() > shoppingCart.get(j).getId()) {
                        Collections.swap(shoppingCart, i, j);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        } else {
//            for (int i = 0; i < shoppingCart2(shoppingCart).size(); i++) {
//                System.out.println(shoppingCart2(shoppingCart).get(i).toString());
//            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i + 1; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getPrice() > shoppingCart.get(j).getPrice()) {
                        Collections.swap(shoppingCart, i, j);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                for (int j = i + 1; j < shoppingCart.size(); j++) {
                    if (shoppingCart.get(i).getPrice() == shoppingCart.get(j).getPrice() && shoppingCart.get(i).getId() > shoppingCart.get(j).getId()) {
                        Collections.swap(shoppingCart, i, j);
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }

//    public ArrayList<Product> shoppingCart1(ArrayList<Product> shoppingCart) {
//        Comparator<Product> comparator = new Comparator<Product>() {
//            public int compare(Product pro1, Product pro2) {
//                return (int) (pro1.getAvgRating() - pro2.getAvgRating());
//            }
//        };
//        Collections.sort(shoppingCart, comparator);
//        return shoppingCart;
//    }
//
//    public ArrayList<Product> shoppingCart2(ArrayList<Product> shoppingCart) {
//        Comparator<Product> comparator = new Comparator<Product>() {
//            public int compare(Product pro1, Product pro2) {
//                return (int) (pro1.getPrice() - pro2.getPrice());
//            }
//        };
//        Collections.sort(shoppingCart, comparator);
//        return shoppingCart;
//    }

    public boolean refundProduct(Product product) {
        if (hasProduct(product)) {
            removeProduct(product);
            updateWallet(product.getPrice());
            product.getStore().addProduct(product);
            product.getStore().setIncome(product.getStore().getIncome() - product.getPrice());
            return true;
        } else {
            return false;
        }
    }

    public boolean hasProduct(Product product) {
        boolean test = false;
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).getId() == product.getId()) {
                test = true;
                break;
            }
        }
        if (test) {
            return true;
        } else {
            return false;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            shoppingCart.remove(product);
            return true;
        } else {
            return false;
        }
    }
}