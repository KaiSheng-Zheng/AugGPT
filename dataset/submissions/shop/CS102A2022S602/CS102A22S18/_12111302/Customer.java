import java.util.ArrayList;
import java.util.Collections;

public class Customer {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

//    public boolean setShoppingCar(Product product)
//    {
//        if(rating>=1&&rating<=5)
//        {
//            ratings.add(rating);  return true;
//        }
//        else  return false;
//    }

    public Customer(String name, float wallet)
    {
        this.name=name;
        this.wallet=wallet;
        cnt++;
        id=cnt;

    }
    public boolean rateProduct(Product product, int rating)
    {
        if(rating>=1&&rating<=5){product.setRating(rating);return true;}
        else return false;
    }
    public void updateWallet(float amount)
    {
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product)
    {
        if(store.hasProduct(product)==true)
        {
            if(this.wallet>= product.getPrice())
        {
            shoppingCart.add(product);
            this.wallet-=product.getPrice();
            store.transact(product,0);
            product.store=store;
            return true;
        }
        else return false;
        }
        else return false;
    }
    public void viewShoppingCart(SortBy sortMethod)
    {
            if(sortMethod.equals(SortBy.PurchaseTime))
            { for(int i=0;i<shoppingCart.size();i++)
            {System.out.println(shoppingCart.get(i).toString());}     }
        if(sortMethod.equals(SortBy.Rating))
        {
            for(int i=0;i<shoppingCart.size()-1;i++)
            {
             for(int j=i+1;j<shoppingCart.size();j++)
              {
                if(shoppingCart.get(j).getAvgRating()<shoppingCart.get(i).getAvgRating())
               {
                  Collections.swap(shoppingCart,i,j);
               }
              }
            }
            for(int i=0;i<shoppingCart.size();i++){System.out.println(shoppingCart.get(i).toString());}
        }
        if(sortMethod.equals(SortBy.Price))
        { for(int i=0;i<shoppingCart.size()-1;i++){
            for(int j=i+1;j<shoppingCart.size();j++)
            {if(shoppingCart.get(j).getPrice()<shoppingCart.get(i).getPrice())
            {
                Collections.swap(shoppingCart,i,j);
            }
            }
        }
            for(int i=0;i<shoppingCart.size();i++){System.out.println(shoppingCart.get(i).toString());}
        }
    }
    public boolean refundProduct(Product product)
    {
        if(shoppingCart.contains(product)==true)
        {
            this.wallet+=product.getPrice();
            shoppingCart.remove(product);
             product.store.transact(product,1);
            return true;
        }
        else return false;
    }
}
