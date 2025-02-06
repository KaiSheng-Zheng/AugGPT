import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class SortByTime implements Comparator<Product>
{
    @Override
    public int compare(Product a,Product b)
    {
        if(a.getTime()>b.getTime()) return 1;
        return -1;
    }
}
class SortByRating implements Comparator<Product>
{
    @Override
    public int compare(Product a,Product b)
    {
        if(a.getAvgRating()>b.getAvgRating()) return 1;
        else if(a.getAvgRating()==b.getAvgRating())
        {
            if(a.getTime()>b.getTime()) return 1;
            return -1;
        }
        return -1;
    }
}
class SortByPrice implements Comparator<Product>
{
    @Override
    public int compare(Product a,Product b)
    {
        if(a.getPrice()>b.getPrice()) return 1;
        else if(a.getPrice()==b.getPrice())
        {
            if(a.getTime()>b.getTime()) return 1;
            return -1;
        }
        return -1;
    }
}
public class Customer
{
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList();
    private float wallet;
    private static int time=0;
    public Customer(String name,float wallet)
    {
        this.name=name;
        this.id=++cnt;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating)
    {
        if(rating<1||rating>5) return false;
        product.getRatings().add(rating);
        return true;
    }
    public void updateWallet(float amount)
    {
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product)
    {
        if(store.hasProduct(product)&&this.wallet>=product.getPrice())
        {
            this.shoppingCart.add(product);
            updateWallet(-product.getPrice());
            store.transact(product,0);
            product.setTime(++time);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod)
    {
        if(this.shoppingCart.size()==0) return;
        switch(sortMethod)
        {
            case PurchaseTime:
                Collections.sort(shoppingCart,new SortByTime());
                for (Product product:shoppingCart) System.out.println(product);
                break;
            case Rating:
                Collections.sort(shoppingCart,new SortByRating());
                for (Product product:shoppingCart) System.out.println(product);
                break;
            case Price:
                Collections.sort(shoppingCart,new SortByPrice());
                for (Product product:shoppingCart) System.out.println(product);
                break;
        }
    }
    public boolean refundProduct(Product product)
    {
        if(!this.shoppingCart.contains(product)) return false;
        this.shoppingCart.remove(product);
        updateWallet(product.getPrice());
        product.belong.transact(product,1);
        return true;
    }
}
