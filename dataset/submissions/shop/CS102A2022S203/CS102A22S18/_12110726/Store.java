import java.util.ArrayList;
public class Store { private static int cnt=0;
    private int id;
    private String name;
    private float income;
    private  ArrayList<Product> productList=new ArrayList<Product>();
    public Store(String name)
    {
        cnt++;
        this.id=cnt;
        this.name=name;
        income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income)
    {
        cnt++;
        this.id=cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product)
    {
        int i=0;
        for(int j=0;j< productList.size();j++)
        {
            if(product==productList.get(j))
            {
                i=1;
            }
        }
        if (i==0){return false;}
        else{return true;}
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
        if(hasProduct(product))
        {
            productList.remove(product);
            return true;
        }
        else
        {
            return false;
        }
    }
    public ArrayList<Product> getProductList()
    {return productList;}
    public void transact(Product product, int method)
    {
        if(method==0)
        {
            productList.remove(product);
            income+=product.getPrice();
        }
        if(method==1)
        {
            productList.add(product);
            income-=product.getPrice();
        }
    }
    public void setincome(float amount)
    {
        income=amount+income;
    }
}
