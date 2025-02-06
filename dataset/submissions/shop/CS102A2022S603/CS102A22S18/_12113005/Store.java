import java.util.ArrayList;
public class Store
{
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList();
    private float income;
    public Store(String name)
    {
        this.name=name;
        this.id=++cnt;
    }
    public Store (String name,ArrayList<Product> productList,float income)
    {
        this.name=name;
        this.id=++cnt;
        this.productList=productList;
        this.income=income;
    }
    public ArrayList<Product> getProductList()
    {
        return this.productList;
    }
    public boolean hasProduct(Product product)
    {
        if(this.productList.contains(product))
        {
            product.belong=this;
            return true;
        }
        return false;
    }
    public boolean addProduct(Product product)
    {
        if(hasProduct(product)) return false;
        this.productList.add(product);
        product.belong=this;
        return true;
    }
    public boolean removeProduct(Product product)
    {
        if(!hasProduct(product)) return false;
        this.productList.remove(product);
        return true;
    }
    public void transact(Product product, int method)
    {
        if(method==0)
        {
            if(removeProduct(product)) this.income+=product.getPrice();
        }
        else
        {
            if(addProduct(product)) this.income-=product.getPrice();
        }
    }
}
