import java.util.ArrayList;

public class Customer
{
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;

    public Customer(String name, float wallet)
    {
        this.name=name;
        this.wallet=wallet;
        shoppingCart=new ArrayList<>();
        cnt++;
        id=cnt;
    }

    public boolean rateProduct(Product product, int rating)
    {
        if(rating>=1 && rating<=5)
        {
            return product.setRating(rating);
        }
        return false;
    }

    public void updateWallet(float amount)
    {
        wallet=wallet+amount;
    }

    public boolean purchaseProduct(Store store, Product product)
    {
        if(store.hasProduct(product))
        {
            store.transact(product,0);
            updateWallet(-product.getPrice());
            shoppingCart.add(product);
            return true;
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod)
    {
        if(sortMethod==SortBy.PurchaseTime)
        {
            for(int i=0;i<shoppingCart.size();i++)
            {
                System.out.println(shoppingCart.get(i));
            }
        }
        if(sortMethod==SortBy.Price)
        {
            ArrayList<Product> output=new ArrayList<>();
            output.addAll(shoppingCart);
            for (int i=0;i<output.size();i++)
            {
                for(int j=i;j<output.size();i++)
                {
                    if(output.get(i).getPrice()>output.get(i).getPrice())
                    {
                        Product tem=output.get(i);
                        output.add(i,output.get(j));
                        output.add(j,tem);
                    }
                }
            }
            for(int i=0;i<output.size();i++)
            {
                System.out.println(output.get(i));
            }

        }
        if(sortMethod==SortBy.Rating)
        {
            ArrayList<Product> output=new ArrayList<>();
            output.addAll(shoppingCart);
            for (int i=0;i<output.size();i++)
            {
                for(int j=i;j<output.size();i++)
                {
                    if(output.get(i).getAvgRating()>output.get(i).getAvgRating())
                    {
                        Product tem=output.get(i);
                        output.add(i,output.get(j));
                        output.add(j,tem);
                    }
                }
            }
            for(int i=0;i<output.size();i++)
            {
                System.out.println(output.get(i));
            }

        }
    }

}