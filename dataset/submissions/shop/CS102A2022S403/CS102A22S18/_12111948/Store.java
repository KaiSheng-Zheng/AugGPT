import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name)
    {
        this.id = ++cnt;
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income)
    {
        this.id = ++cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product)
    {
        return productList.contains(product);
    }
    public boolean addProduct(Product product)
    {
        if(hasProduct(product))
            return false;
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product)
    {
        if(!hasProduct(product))
            return false;
        productList.remove(product);
        return true;
    }
    public ArrayList<Product> getProductList()
    {
        return productList;
    }
    public void transact(Product product, int method)
    {
        if(method == 0)
        {
            income += product.getPrice();
            removeProduct(product);
        }
        else if(method == 1)
        {
            addProduct(product);
            income -= product.getPrice();
        }
    }
}
