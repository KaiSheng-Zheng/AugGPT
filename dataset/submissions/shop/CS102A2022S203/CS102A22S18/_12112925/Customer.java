import java.util.*;
enum SortBy {
    PurchaseTime, Rating, Price

}
public class Customer  {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Product,Store>hashMap=new HashMap<>();
    private Calendar now = Calendar.getInstance();
    private static int time=0;
    public Customer(String name, float wallet)
    {
        this.cnt++;
        this.id=this.cnt;
        this.name=name;
        this.wallet=wallet;
        this.shoppingCart=new ArrayList<>();
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
        if(store.hasProduct(product)&&this.wallet>=product.getPrice())
        {
            product.setTime(time++);
            shoppingCart.add(product);
            this.wallet-=product.getPrice();
            store.transact(product,0);
            hashMap.put(product,store);
            return true;
        }
        return false;
    }
    public void output()
    {
        for(Product product:shoppingCart)
        {
            System.out.println(product);
        }
    }
    public void sortby_time()
    {
        shoppingCart.sort(new Comparator<Product>() {
            @Override
            public int compare(Product product, Product product1) {
                return product.getTime()-product1.getTime();
            }
        });
    }
    public void sortby_price()
    {
        shoppingCart.sort(new Comparator<Product>() {
            @Override
            public int compare(Product product, Product product1) {
                float a=product.getPrice()-product1.getPrice();
                if(a!=0)return a>0?1:-1;
                a=product.getTime()-product1.getTime();
                return a>0?1:-1;
            }
        });
    }
    public void sortby_rating()
    {
        shoppingCart.sort(new Comparator<Product>() {
            @Override
            public int compare(Product product, Product product1) {
                float a=Float.parseFloat(String.format("%.1f",product.getAvgRating()))-Float.parseFloat(String.format("%.1f",product1.getAvgRating()));
                if(a!=0)return a>0?1:-1;
                a=product.getAvgRating()-product1.getAvgRating();
                if(a!=0)return a>0?1:-1;
                a=product.getTime()-product1.getTime();
                return a>0?1:-1;

            }
        });
    }
    public void viewShoppingCart(SortBy sortMethod)
    {
        if(sortMethod==SortBy.PurchaseTime)
        {
            sortby_time();
            output();
        }else if(sortMethod==SortBy.Price)
        {
            sortby_price();
            output();
        }else
        {
            sortby_rating();
            output();
        }

    }
    public boolean refundProduct(Product product)
    {
        for(int i=0;i<shoppingCart.size();i++)
        {
            if(shoppingCart.get(i).getId()==product.getId())
            {
                this.wallet+=product.getPrice();
                shoppingCart.remove(i);
                Store store=hashMap.get(product);
                store.transact(product,1);
                hashMap.remove(product);
                return true;
            }
        }
        return false;

    }


}
