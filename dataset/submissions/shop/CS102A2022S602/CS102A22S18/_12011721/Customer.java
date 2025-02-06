import java.util.ArrayList;

public class Customer
{
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products; default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        this.name = name;
        this.wallet = wallet;
        cnt ++;
        id = cnt;
    }

    public boolean rateProduct(Product product, int rating)
    {
        return product.setRating(rating);
    }

    public void updateWallet(float amount)
    {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product)
    {
        if(store.hasProduct(product))
        {
            if(wallet >= product.getPrice())
            {
                store.transact(product, 0);
                updateWallet(-product.getPrice());
                shoppingCart.add(product);
                return true;
            }
        }
        return false;
    }

    public void viewShoppingCart(SortBy sortMethod)
    {
        switch (sortMethod)
        {
            case Price:
                viewPrice();
                break;
            case Rating:
                viewRating();
                break;
            case PurchaseTime:
                viewBuytime();
                break;
        }
    }

    private void viewPrice()
    {
        ArrayList<Product> products = new ArrayList<>(shoppingCart);
        for(int i = 0; i < shoppingCart.size() - 1; i ++)
        {
            int id = 0;
            for (int j = 0; j < products.size() && products.size() >= 2; j ++)
            {
                if(products.get(id).getPrice() > products.get(j).getPrice())
                    id = j;
            }
            System.out.println(products.get(id));
            products.remove(id);
        }
        System.out.println(products.get(0));

    }

    private void viewRating()
    {
        ArrayList<Product> products = new ArrayList<>(shoppingCart);
        for(int i = 0; i < shoppingCart.size() - 1; i ++)
        {
            int id = 0;
            for (int j = 0; j < products.size() && products.size() >= 2; j ++)
            {
                if(products.get(id).getAvgRating() > products.get(j).getAvgRating())
                    id = j;
            }
            System.out.println(products.get(id));
            products.remove(id);
        }
        System.out.println(products.get(0));
    }

    private void viewBuytime()
    {
        for(Product product : shoppingCart)
        {
            System.out.println(product);
        }
    }

    public boolean refundProduct(Product product)
    {
        return true;
    }

    public static void main(String[] args) {
        //to test
        Product p1 = new Product("p1", 1);
        Product p2 = new Product("p2", 2);
    }
}
