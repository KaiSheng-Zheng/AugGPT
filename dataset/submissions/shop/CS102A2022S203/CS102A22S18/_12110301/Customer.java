import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Customer {

    private HashMap<Product, Store> jilu = new HashMap<>();

    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart= new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;



    public Customer(String name, float wallet)
    {
        this.name = name;
        this.wallet = wallet;;


        Customer.cnt++;
        this.id = Customer.cnt;




    }

    public boolean rateProduct(Product product, int rating)
    {
        return product.setRating(rating);
    }

    public void updateWallet(float amount)
    {
        this.wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product)
    {
        if (this.wallet >=product.npric()&&store.hasProduct(product)  )
        {
            store.transact(product, 0);
            this.shoppingCart.add(product);



            this.wallet-= product.npric();
            ;
            this.jilu.put(product, store);
            return true;
        }
        return false;

    }
    public void viewShoppingCart(SortBy sortMethod)
    {

        Product[] ptone=this.shoppingCart.toArray(new Product[0]);

        if (sortMethod==SortBy.Rating)
        {
        Arrays.sort(ptone, (x, y) ->Float.compare(x.getAvgRating(), y.getAvgRating()));

        for (Product product :ptone)
        {
            System.out.println(product);
        }
        }
        else if (sortMethod==SortBy.PurchaseTime)
        {
            for (Product product:ptone)
            {
                System.out.println(product);
            }
        }
        else if (sortMethod==SortBy.Price)
        {
            Arrays.sort(ptone,(x, y)->Float.compare(x.npric(), y.npric()));

            for (Product product:ptone)
            {
                System.out.println(product);
            }
        }
    }

    public boolean refundProduct(Product product)
    {
        if (this.shoppingCart.contains(product))
        {
            this.shoppingCart.remove(product);
            this.wallet+=product.npric();
            ;

            this.jilu.get(product).transact(product, 1);
            this.jilu.remove(product);



            return true;
        }

        return false;
    }


}