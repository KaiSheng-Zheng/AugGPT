import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;
    ArrayList<Product> ratesort = new ArrayList<>();
    ArrayList<Store> myStores = new ArrayList<>();

    public Customer(String name, float wallet) {

        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }

        return false;
    }

    public void updateWallet(float amount) {
        wallet+=amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet>=product.getPrice())
        {
            updateWallet((-1)*product.getPrice());
            shoppingCart.add(product);
            store.transact(product,0);
            if (!myStores.contains(store)){
                myStores.add(store);
            }
            return true;

        }
        else
            return false;
    }

    public void viewShoppingCart(SortBy sortMethod)
    {
        switch (sortMethod)
        {
            case Price:
            {
                Collections.sort(shoppingCart,new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2)
                    {
                        if(p1.getPrice() > p2.getPrice())
                        {
                            return 1;
                        }
                        else if (p1.getPrice() == p2.getPrice())
                        {
                            return 0;
                        }
                        else{
                            return -1;
                        }
                    }
                });
                break;
            }
            case Rating:
            {
                Collections.sort(shoppingCart,new Comparator<Product>() {
                    @Override
                    public int compare(Product p1, Product p2)
                    {
                        if(p1.getAvgRating() > p2.getAvgRating())
                        {
                            return 1;
                        }
                        else if (p1.getAvgRating() == p2.getAvgRating())
                        {
                            return 0;
                        }
                        else{
                            return -1;
                        }
                    }
                });
                break;
            }
            default:
                break;
        }

        for (int i=0;i<shoppingCart.size();i++) {
            System.out.println(shoppingCart.get(i));
        }
    }

    public boolean refundProduct(Product product) {
        /*if(this.shoppingCart.contains(product))
        {
            for(Store store:myStores)
            {
                if (store.hasProduct(product))
                {
                    store.transact(product, 1);
                }
            }
            shoppingCart.remove(product);
            this.wallet += product.getPrice();

            return true;
        }
        else
        {
            return false;
        }
    }*/Store k = new Store();
  k.transact(product,1);
        this.wallet += product.getPrice();
        return true;
    }}

