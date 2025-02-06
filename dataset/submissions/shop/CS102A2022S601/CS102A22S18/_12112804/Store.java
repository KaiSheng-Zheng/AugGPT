import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name)
    {
        this.name=name;
        this.income=0;
        productList=new ArrayList<Product>();
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
        return productList.contains(product);
    }
    public boolean addProduct(Product product)
    {
        if(productList.contains(product))
            return false;
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product)
    {
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
            return false;

    }
    public ArrayList<Product> getProductList()
    {
        return productList;
    }
    public void transact(Product product, int method)
    {
        if(method==0)
        {
            productList.remove(product);
            income+=product.getPrice();
        }
        else if(method==1)
        {
            productList.add(product);
            income-=product.getPrice();
        }
    }
}
