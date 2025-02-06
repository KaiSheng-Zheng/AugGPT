import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();
    private float wallet;

    public Customer(String name, float wallet) {
        ++cnt;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (1 <= rating && rating <= 5) {
            product.setRating(rating);
            return true;
        } else return false;
    }

    public void updateWallet(float amount) {
        wallet = wallet + amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if ((product.getPrice() <= wallet) && (store.hasProduct(product))) {
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            product.sstore=store;
            return true;
        }
        return false;
    }


    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shoppingCartbefore=new ArrayList<Product>();
        shoppingCartbefore.addAll(shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            Collections.sort(shoppingCartbefore, new Comparator<Product>() {
                public int compare(Product a1, Product a2) {
                    if (shoppingCartbefore.indexOf(a1) > shoppingCartbefore.indexOf(a2))
                        return 1;
                    else
                        return -1;
                }
            });
            for (Product product : shoppingCartbefore) {
                System.out.println(product.toString());
            }
        } else if (sortMethod == SortBy.Rating) {
            if(shoppingCart.size()!=0) {
                Collections.sort(shoppingCartbefore, new Comparator<Product>() {
                    public int compare(Product a1, Product a2) {
                        if (a1.getAvgRating() > a2.getAvgRating())
                            return 1;
                        if (a1.getAvgRating() < a2.getAvgRating())
                            return -1;
                        if (a1.getAvgRating() == a2.getAvgRating())
                            return 0;
                         return 0;
                    }
                });
                for (Product product : shoppingCartbefore) {
                    System.out.println(product.toString());
                }
            }
        } else {
            Collections.sort(shoppingCartbefore, new Comparator<Product>() {
                public int compare(Product a1, Product a2) {
                    if (a1.getPrice() > a2.getPrice())
                        return 1;
                    if (a1.getPrice() < a2.getPrice())
                        return -1;
                    if (a1.getPrice() == a2.getPrice())
                        return 0;
                    return 0;
                }
            });
            for (Product product : shoppingCartbefore) {
                System.out.println(product.toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        if(!shoppingCart.contains(product))
            return false;
        Store storebackto=product.sstore;
        storebackto.transact(product,1);
        shoppingCart.remove(product);
        updateWallet(product.getPrice());
        return true;
    }
}
