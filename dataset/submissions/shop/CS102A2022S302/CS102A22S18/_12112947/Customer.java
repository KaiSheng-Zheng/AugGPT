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
    private HashMap<Product,Store> purchase_record =new HashMap<>();
    private static int purchase_Time =0;
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
            product.setTime(++purchase_Time);
            shoppingCart.add(product);
            this.wallet-=product.getPrice();
            purchase_record.put(product,store);
            store.transact(product,0);
            return true;
        }
        return false;
    }
    public void viewShoppingCart(SortBy sortMethod)
    {
        if(sortMethod==SortBy.Price)
        {
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product product, Product product1) {
                    float tmp=product.getPrice()-product1.getPrice();
                    if(tmp>0)return 1;
                    if(tmp<0) return-1;
                    tmp=product.getTime()-product1.getTime();
                    if(tmp>0)return 1;
                    return -1;
                }
            });

        }else if(sortMethod==SortBy.PurchaseTime)
        {
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product product, Product product1) {
                    return product.getTime()-product1.getTime();
                }
            });
        }else
        {
            shoppingCart.sort(new Comparator<Product>() {
                @Override
                public int compare(Product product, Product product1) {
                    float tmp=Float.parseFloat(String.format("%.1f",product.getAvgRating()))-Float.parseFloat(String.format("%.1f",product1.getAvgRating()));
                    if(tmp>0)return 1;
                    if(tmp<0)return -1;
                    tmp=product.getAvgRating()-product1.getAvgRating();
                    if(tmp>0)return 1;
                    if(tmp<0)return -1;
                    tmp=product.getTime()-product1.getTime();
                    if(tmp>0)return 1;
                    return -1;

                }
            });
        }
        for(Product product:shoppingCart)
        {
            System.out.println(product);
        }

    }
    public boolean refundProduct(Product product)
    {
        for(Product product1:shoppingCart)
        {
            if(product1.getId()==product.getId())
            {
                Store store= purchase_record.get(product);
                store.transact(product,1);
                this.wallet+=product.getPrice();
                shoppingCart.remove(product);
                purchase_record.remove(product);
                return true;
            }
        }
        return false;
    }
}
