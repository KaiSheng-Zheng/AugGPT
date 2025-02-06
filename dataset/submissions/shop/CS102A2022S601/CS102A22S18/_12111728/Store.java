import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<Product>();
    private float income=0;
    public Store(String name)
    {
        cnt++;
        id=cnt;
        this.name=name;
    }
    public Store(String name, ArrayList<Product> productList, float income)
    {
        cnt++;
        id=cnt;
        this.name=name;
        for(int i=0;i<=(productList.size()-1);i++)
        {
            this.productList.add(productList.get(i));
        }
        this.income=income;
    }
    public boolean hasProduct(Product product)
    {
        for(int i=0;i<=productList.size()-1;i++)
        {
            if(productList.get(i).getId()==(product.getId())) return true;
        }
        return false;
    }
    public int hasProduct(Product product,int a)
    {
        for(int i=0;i<=productList.size()-1;i++)
        {
            if(productList.get(i).getId()==(product.getId())) return i;
        }
        return -1;
    }
    public boolean addProduct(Product product)
    {
        if(hasProduct(product)) return false;
        else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product)
    {
        int a=hasProduct(product,1);
        if(a==-1) return false;
        else {
            productList.remove(a);
            return true;
        }
    }
    public ArrayList<Product> getProductList()
    {
        return productList;
    }
    public void transact(Product product, int method)
    {
        if (method==0)
        {
            removeProduct(product);
            income+=product.getPrice();
        }
        else
        {
            productList.add(product);
            income-=product.getPrice();
        }
    }
}
