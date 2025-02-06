import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Customer {
    private static int cnt=0;
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();
    private float wallet;
    private int purchases=0;
    public Customer(String name, float wallet)
    {
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating)
    {
        return product.setRating(rating);
    }
    public void updateWallet(float amount)
    {
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product)
    {
        if(store.hasProduct(product)&&wallet>=product.getPrice())
        {
            wallet-= product.getPrice();
            shoppingCart.add(product);
            product.setStorefrom(store);
            purchases++;
            product.setPurchasetime(purchases);
            store.transact(product,0);
            return true;
        }
        else
            return false;
    }
    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> shoppingchange = new ArrayList<Product>(shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            shoppingchange.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getPurchasetime() > o2.getPurchasetime())
                        return 1;
                    else
                        return -1;
                }
            });
            for (int i = 0; i < shoppingchange.size(); i++) {
                System.out.println(shoppingchange.get(i));
            }
        } else if (sortMethod == SortBy.Rating) {
            shoppingchange.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return Float.compare(o1.getAvgRating(), o2.getAvgRating());
                }

            });
            for (int i = 0; i < shoppingchange.size(); i++) {
                System.out.println(shoppingchange.get(i));
            }
        } else {
            shoppingchange.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return Float.compare(o1.getPrice(), o2.getPrice());
                }

            });
            for (int i = 0; i < shoppingchange.size(); i++) {
                System.out.println(shoppingchange.get(i));
            }
        }
    }

    public boolean refundProduct(Product product)
    {
        if(shoppingCart.contains(product))
        {
            wallet+= product.getPrice();
            shoppingCart.remove(product);
            product.getStorefrom().transact(product,1); //???
            return true;
        }
        else
            return false;
    }
}
