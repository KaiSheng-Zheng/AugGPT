import java.util.ArrayList;

public class Store {
    private int id;
    private String name;
    private ArrayList<Product> mai = new ArrayList<>();;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    private static int cnt = 0;

    public Store(String name )
    {
        this.name = name;
        this.income = 0;

        Store.cnt++;
        this.id = Store.cnt;;

    }

    public Store(String name, ArrayList<Product> productList, float income)
    {
        this.name = name;
        this.productList = productList;
        this.income = income;

        Store.cnt++;
        this.id = Store.cnt;



    }

    public boolean hasProduct(Product product)
    {
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product)
    {
        return !hasProduct(product) && this.productList.add(product);
    }
    public boolean removeProduct(Product product)
    {
        return this.productList.remove(product);
    }
    public ArrayList<Product> getProductList()
    {
        return this.productList;
    }
    public void transact(Product product, int method)
    {

        if (method==0)
        {
            if (removeProduct(product))
            {
                this.income +=product.npric();
                this.mai.add(product);;
            }
        }
        else if (method ==1)
        {
            if (this.mai.contains(product) && addProduct(product))
            {
                this.income -=product.npric();

                this.mai.remove(product);
            }
        }

    }
}