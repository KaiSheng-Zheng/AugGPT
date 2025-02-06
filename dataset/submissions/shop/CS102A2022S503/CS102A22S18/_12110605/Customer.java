import java.util.ArrayList;

public class Customer
{
    public static void swap(ArrayList<Product> shoppingCart,int i, int j)
    {
        Product temp1;
        Product temp2;
        temp1=shoppingCart.get(i);
        temp2=shoppingCart.get(j);
        shoppingCart.remove(i);
        shoppingCart.remove(j);
            shoppingCart.add(j,temp1);
            shoppingCart.add(i,temp2);
    }
    public static void sort(ArrayList<Product> shoppingCart)
    {
        for(int i=1;i<shoppingCart.size();i++)
        {
            for(int j=i;j>0;j--)
            {
                if(shoppingCart.get(j).getAvgRating()< shoppingCart.get(j-1).getAvgRating())
                {
                    swap(shoppingCart,j,j-1);
                }
            }
        }
    }
    public static void sort0(ArrayList<Product> shoppingCart)
    {
        for(int i=1;i<shoppingCart.size();i++)
        {
            for(int j=i;j>0;j--)
            {
                if(shoppingCart.get(j).getPrice()< shoppingCart.get(j-1).getPrice())
                {
                    swap(shoppingCart,j,j-1);
                }
            }
        }
    }
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private ArrayList<Store> storeList= new ArrayList<>();
    private float wallet;
    public Customer(String name, float wallet)
    {
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }
    public boolean rateProduct(Product product, int rating)
    {
        if(product.setRating(rating))
        {
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
        if(store.hasProduct(product)&&wallet >= product.getPrice())
        {
            updateWallet(product.getPrice()*(-1));
            shoppingCart.add(product);
            storeList.add(store);
            store.removeProduct(product);
            store.transact(product,0);
            return true;
        }
        else
        {
            return false;
        }
    }
    public void viewShoppingCart(SortBy sortMethod)
    {

        if(sortMethod==SortBy. PurchaseTime)
        {
            for (Product product : shoppingCart) {
                System.out.println(product);
            }
        }
        if(sortMethod==SortBy. Rating)
        {
            ArrayList<Product> shoppingCart0=new ArrayList<>();
            for(int i = 0;i<shoppingCart.size();i++)
            {
                shoppingCart0.add(shoppingCart.get(i));
            }
            sort( shoppingCart0);
            for (Product product : shoppingCart0)
            {
                System.out.println(product);
            }

        }
        if(sortMethod==SortBy. Price)
        {
            ArrayList<Product> shoppingCart0=new ArrayList<>();
            for(int i = 0;i<shoppingCart.size();i++)
            {
                shoppingCart0.add(shoppingCart.get(i));
            }
            sort0( shoppingCart0);
            for (Product product : shoppingCart0)
            {
                System.out.println(product);
            }

        }
    }
    public boolean refundProduct(Product product)
    {
        boolean re=false;
        Store store;
        for(int i = 0;i<shoppingCart.size();i++)
        {
            if(shoppingCart.get(i).getId()==product.getId())
            {
                updateWallet(product.getPrice());
                shoppingCart.remove(product);
                store=storeList.get(i);
                storeList.remove(i);
                store.transact(product,1);
                store.addProduct(product);
                re= true;
                break;
            }
            else
            {
                re= false;
            }
        }
        return re;
    }
}
