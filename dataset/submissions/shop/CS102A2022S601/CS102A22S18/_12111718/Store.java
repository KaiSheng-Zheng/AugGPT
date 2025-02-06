import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<Product>();
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){return false;}
        else {productList.add(product);return true;}
    }
    public boolean removeProduct(Product product){
        if (!hasProduct(product)){return false;}
        else {productList.remove(product);return true;}
    }
    public ArrayList<Product> getProductList(){return productList;}
    public void transact(Product product, int method){
        switch (method){
            case 0:removeProduct(product);income+=product.getPrice();break;
            case 1:addProduct(product);income-= product.getPrice();break;
        }
    }
}
