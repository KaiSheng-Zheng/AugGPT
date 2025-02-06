import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name)
    {
        productList=new ArrayList<>();
        this.cnt++;
        this.id=cnt;
        this.name=name;
        this.income=0;

    }
    public Store(String name, ArrayList<Product> productList, float income)
    {
        //productList=new ArrayList<>();
        this.cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product)
    {
        for(Product produ:productList)
        {
            if(produ.getId()==product.getId())return true;
        }
        return false;
    }
    public boolean addProduct(Product product)
    {
       if(hasProduct(product))return false;
       productList.add(product);
       return true;

    }
    public boolean removeProduct(Product product)
    {
        for(int i=0;i<productList.size();i++)
        {
            if(productList.get(i).getId()==product.getId())
            {
                productList.remove(i);
                return true;
            }
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
                this.income += product.getPrice();
                this.removeProduct(product);
            
        }
        else{
            this.income-=product.getPrice();
            this.productList.add(product);
        }

    }
}
