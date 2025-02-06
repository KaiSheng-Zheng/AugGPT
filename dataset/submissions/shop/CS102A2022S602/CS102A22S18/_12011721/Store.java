import java.util.ArrayList;

public class Store
{
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        for (Product product : productList)
        {
            product.setInstore(true);
        }
        this.income = income;
        cnt ++;
        this.id = cnt;
    }

    public Store(String name) {
        this.name = name;
        cnt ++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product)
    {
        for(Product productin : productList)
        {
            if(productin.equals(product))
                return true;
        }
        return false;
    }

    public boolean addProduct(Product product)
    {
        if(product.isInstore())
            return false;
        else
        {
            product.setInstore(true);
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product)
    {
        int id = productid(product);
        if(id == 0)
            return false;
        else
        {
            product.setInstore(false);
            productList.remove(id);
            return true;
        }

    }

    public ArrayList<Product> getProductList()
    {
        return productList;
    }

    public void transact(Product product, int method)
    {
        if(method == 0)
        {
            int id = productid(product);
            income += productList.get(id).getPrice();
            product.setInstore(false);
            productList.remove(id);
        }
        else if(method == 1)
        {
            income -= product.getPrice();
            addProduct(product);
        }
    }

    public int productid(Product product)
    {
        //id should be i+1.
        for(int i = 0; i < productList.size(); i ++)
        {
            if(product.equals(productList.get(i)))
                return i;
        }
        return 0;
    }
}
