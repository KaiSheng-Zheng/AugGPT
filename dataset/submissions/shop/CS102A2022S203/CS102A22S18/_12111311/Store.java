import java.util.ArrayList;

public class Store
{
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name)
    {
        cnt++;
        id=cnt;
        this.name=name;
        this.income=0;
    }

    public Store(String name,ArrayList<Product> productList,float income)
    {
        cnt++;
        id=cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }

    public boolean hasProduct(Product product)
    {
        int s=productList.size();
        for(int i=0;i<s;i++)
            if(product.getId()==productList.get(i).getId())
                return true;
        return false;
    }

    public boolean addProduct(Product product)
    {
        int s=productList.size();
        for(int i=0;i<s;i++)
            if(product.getId()==productList.get(i).getId())
                return false;
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product)
    {
        int s=productList.size();
        for(int i=0;i<s;i++)
            if(product.getId()==productList.get(i).getId())
            {
                productList.remove(i);
                return true;
            }
        return false;
    }

    public ArrayList<Product> getProductList()
    {
        return productList;
    }

    public void transact(Product product,int method)
    {
        if(method==0)//purchase
        {
            income+=product.getPrice();
            removeProduct(product);
        }
        if(method==1)//refund
        {
            income-=product.getPrice();
            addProduct(product);
        }
    }

    public void release()
    {
        System.out.println(id);
        System.out.println(name);
        System.out.println(income);
    }
}
