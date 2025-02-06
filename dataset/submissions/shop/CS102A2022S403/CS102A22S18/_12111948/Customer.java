import java.util.*;

enum SortBy
{
    PurchaseTime, Rating, Price;
}
public class Customer {
    private static int cnt;
    //public static int Cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    //public static Map<Product, Integer> timelineArray = new HashMap<>();
    private Map<Product, Store> giveBackArray = new HashMap<>();
    private float wallet;
    public Customer(String name, float wallet)
    {
        this.id = ++cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating)
    {
        return product.setRating(rating);
    }
    public float getWallet()
    {
        return wallet;
    }
    public void updateWallet(float amount)
    {
        wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product)
    {
        if(!store.hasProduct(product))
            return false;
        if(getWallet() < product.getPrice())
            return false;
        updateWallet(-product.getPrice());
        store.transact(product,0);
        shoppingCart.add(product);
        giveBackArray.put(product, store);
        //timelineArray.put(product, ++Cnt);
        return true;
    }
    public void viewShoppingCart(SortBy sortMethod)
    {
        ArrayList<Product> res = shoppingCart;
        if(sortMethod.equals(SortBy.PurchaseTime))
        {
//            Collections.sort(res, new PurchaseTime());
        }
        else if(sortMethod.equals(SortBy.Rating))
        {
            Collections.sort(res, new Rating());
        }
        else if(sortMethod.equals(SortBy.Price))
        {
            Collections.sort(res, new Price());
        }
        for(Product p : res)
        {
            System.out.println(p);
        }
    }
    public boolean refundProduct(Product product)
    {
        if(!shoppingCart.contains(product))
            return false;
        shoppingCart.remove(product);
        updateWallet(product.getPrice());
        giveBackArray.get(product).transact(product,1);
        giveBackArray.remove(product);
        return true;
    }
}
//class PurchaseTime implements Comparator<Product>
//{
//    public int compare(Product p1, Product p2)
//    {
//        return (Customer.timelineArray.get(p1) < Customer.timelineArray.get(p2)) ? -1 : 1;
//    }
//}
class Rating implements Comparator<Product>
{
    public int compare(Product p1, Product p2)
    {
        return (p1.getAvgRating() < p2.getAvgRating()) ? -1 : 1;
        //return (p1.getAvgRating() == p2.getAvgRating()) ? (Customer.timelineArray.get(p1) < Customer.timelineArray.get(p2) ? -1 : 1) : ((p1.getAvgRating() < p2.getAvgRating()) ? -1 : 1);
    }
}
class Price implements Comparator<Product>
{
    public int compare(Product p1, Product p2)
    {
        return (p1.getPrice() < p2.getPrice()) ? -1 : 1;
        //return (p1.getPrice() == p2.getPrice()) ? (Customer.timelineArray.get(p1) < Customer.timelineArray.get(p2) ? -1 : 1) : ((p1.getPrice() < p2.getPrice()) ? -1 : 1);
    }
}
