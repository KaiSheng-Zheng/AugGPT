
import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        income=0;
        productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.productList=productList;//??should I use reference or get a new object?
        this.income=income;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);//reference if different?
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)) return false;
        else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0) {
            income=income+product.getPrice();
            productList.remove(product);
        }
        if(method==1){
            income=income-product.getPrice();
            addProduct(product);
        }
    }
}
