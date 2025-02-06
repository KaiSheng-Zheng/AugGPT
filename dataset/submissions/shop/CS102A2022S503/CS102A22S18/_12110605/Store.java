import java.util.ArrayList;

public class Store
{
    private static int cnt;
    private int id=1;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name)
    {
        this.name=name;
        income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income)
    {
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product)
    {
        int l = productList.size();
        boolean re = false;

                for (Product value : productList) {
                    if (value.getId() == product.getId())
                    {
                        re = true;
                        break;
                    }
                }
                return re;


    }

    public boolean addProduct(Product product)
    {
        if(hasProduct(product))
        {
            return false;
        }
        else
        {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product)
    {
        if(!hasProduct(product))
        {
            return false;
        }
        else
        {
            productList.remove(product);
            return true;
        }
    }
    public ArrayList<Product> getProductList()
    {
        return productList;
    }
    public void transact(Product product, int method)
    {
        if(method==0)
        {
            removeProduct(product);
            income += product.getPrice();
        }
        if(method==1)
        {
            addProduct(product);
            income -= product.getPrice();
        }
    }

}
