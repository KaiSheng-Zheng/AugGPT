import java.util.*;

public class Customer {
    HashMap<Product,Store> shit = new HashMap<Product,Store>();
    private static int purchasetime=0;
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();// The list of purchased products; default is empty.
    private float wallet;
    public Customer(String name,float wallet)
    {
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating)
    {
        if(rating>=1 && rating<=5)
        {
            product.setRating(rating);
            return true;
        }
        else
        {
            return false;
        }
    }
    public void updateWallet(float amount)
    {
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product)
    {
        if(store.hasProduct(product) && wallet>=product.getPrice())
        {
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            shit.put(product,store);
            purchasetime++;
            product.setTime(purchasetime);
            return true;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod)
    {
        if(sortMethod==SortBy.Rating)
        {
            Collections.sort(shoppingCart,comparatorRating);
        }
        if(sortMethod==SortBy.Price)
        {
            Collections.sort(shoppingCart,comparatorPrice);
        }
        for(int i=0;i<=shoppingCart.size()-1;i++)
        {
            System.out.println(shoppingCart.get(i));
        }
    }
    public boolean refundProduct(Product product)
    {
        if(shoppingCart.contains(product))
        {
            int i=shoppingCart.indexOf(product);
            shit.get(product).transact(product,1);
            shoppingCart.remove(i);
            shit.remove(product);
            updateWallet(product.getPrice());
            return true;
        }
        else return false;
    }
    Comparator<Product> comparatorRating = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            if(o1.getAvgRating()>o2.getAvgRating()) return 1;
            else if(o1.getAvgRating()<o2.getAvgRating()) return -1;
            else if(o1.getTime()>o2.getTime()) return 1;
            else if(o1.getTime()<o2.getTime()) return -1;
            else return 0;
        }
    };
    Comparator<Product> comparatorPrice = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            if(o1.getPrice()>o2.getPrice()) return 1;
            else if(o1.getPrice()<o2.getPrice()) return -1;
            else if(o1.getTime()>o2.getTime()) return 1;
            else if(o1.getTime()<o2.getTime()) return -1;
            else return 0;
        }
    };
}
