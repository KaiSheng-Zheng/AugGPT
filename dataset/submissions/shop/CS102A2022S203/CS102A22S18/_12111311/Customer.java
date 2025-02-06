import java.util.ArrayList;

public class Customer
{
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet; 

    public Customer(String name, float wallet)
    {
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;
    }

    public boolean rateProduct(Product product,int rating)
    {
        return product.setRating(rating);
    }

    public void updateWallet(float amount)
    {
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store,Product product)
    {
        if(store.hasProduct(product)&&wallet>=product.getPrice())
        {
            wallet-=product.getPrice();
            product.setPurchaseTime();
            product.setStore(store);
            shoppingCart.add(product);
            store.transact(product,0);
            return true;
        }
        return false;
    }

    public boolean refundProduct(Product product)
    {
        int s=shoppingCart.size();
        for(int i=0;i<s;i++)
        {
            if(product.getId()==shoppingCart.get(i).getId())
            {
                wallet+=product.getPrice();
                shoppingCart.remove(i);
                product.getStore().transact(product,1);
                return true;
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod)
    {
        int s=shoppingCart.size()-1;
        if(s==0)
            return;
        if(sortMethod.toString()=="Rating")
            ratingSort(0,s);
        if(sortMethod.toString()=="Price")
            priceSort(0,s);
        for(int i=0;i<=s;i++)
            System.out.println(shoppingCart.get(i).toString());
        timeSort(0,s);
    }

    private void ratingSort(int l,int r)
    {
        for(int i=r-1;i>=l;i--)
		    for(int j=i;j<r;j++)
                if(shoppingCart.get(j).getAvgRating()>shoppingCart.get(j+1).getAvgRating())
                {
                    Product t=shoppingCart.get(j);
                    shoppingCart.set(j,shoppingCart.get(j+1));
                    shoppingCart.set(j+1,t);
                }
        // int i=l,j=r;
        // float m=shoppingCart.get((l+r)>>1).getAvgRating();
        // while(i<=j)
        // {
        //     while(shoppingCart.get(i).getAvgRating()<m)
        //         i++;
        //     while(shoppingCart.get(j).getAvgRating()>m)
        //         j--;
        //     if(i<=j)
        //     {
        //         Product t=shoppingCart.get(i);
        //         shoppingCart.set(i,shoppingCart.get(j));
        //         shoppingCart.set(j,t);
        //         i++;j--;
        //     }
        // }
        // if(l<j)
        //     ratingSort(l,j);
        // if(i<r)
        //     ratingSort(i,r);
    }

    private void priceSort(int l,int r)
    {
        for(int i=r-1;i>=l;i--)
		    for(int j=i;j<r;j++)
                if(shoppingCart.get(j).getPrice()>shoppingCart.get(j+1).getPrice())
                {
                    Product t=shoppingCart.get(j);
                    shoppingCart.set(j,shoppingCart.get(j+1));
                    shoppingCart.set(j+1,t);
                }
        // int i=l,j=r;
        // float m=shoppingCart.get((l+r)>>1).getPrice();
        // while(i<=j)
        // {
        //     while(shoppingCart.get(i).getPrice()<m)
        //         i++;
        //     while(shoppingCart.get(j).getPrice()>m)
        //         j--;
        //     if(i<=j)
        //     {
        //         Product t=shoppingCart.get(i);
        //         shoppingCart.set(i,shoppingCart.get(j));
        //         shoppingCart.set(j,t);
        //         i++;j--;
        //     }
        // }
        // if(l<j)
        //     priceSort(l,j);
        // if(i<r)
        //     priceSort(i,r);
    }

    private void timeSort(int l,int r)
    {
        for(int i=r-1;i>=l;i--)
		    for(int j=i;j<r;j++)
                if(shoppingCart.get(j).getPurchaseTime()>shoppingCart.get(j+1).getPurchaseTime())
                {
                    Product t=shoppingCart.get(j);
                    shoppingCart.set(j,shoppingCart.get(j+1));
                    shoppingCart.set(j+1,t);
                }
        // int i=l,j=r;
        // int m=shoppingCart.get((l+r)>>1).getPurchaseTime();
        // while(i<=j)
        // {
        //     while(shoppingCart.get(i).getPurchaseTime()<m)
        //         i++;
        //     while(shoppingCart.get(j).getPurchaseTime()>m)
        //         j--;
        //     if(i<=j)
        //     {
        //         Product t=shoppingCart.get(i);
        //         shoppingCart.set(i,shoppingCart.get(j));
        //         shoppingCart.set(j,t);
        //         i++;j--;
        //     }
        // }
        // if(l<j)
        //     timeSort(l,j);
        // if(i<r)
        //     timeSort(i,r);
    }

    public void release()
    {
        System.out.println(id);
        System.out.println(name);
    }
}
