import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    private final int id;
    private final String name;
    private ArrayList<Product> productList=new ArrayList<Product>(){};
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
        this.productList = productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method ==0){
            removeProduct(product);
            income += product.getPrice();
        }else if(method ==1){
            addProduct(product);
            income -= product.getPrice();
        }
    }
}