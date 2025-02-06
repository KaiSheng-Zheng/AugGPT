
import java.util.ArrayList;
public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id=0;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income=0;
public Store(){
    this.name="test";

}
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
        if(productList.contains(product)){
            return false;
        }
        else {
            productList.add(product);
            product.storenumber=cnt;
            product.from=this;

            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
        else {return false;}
    }
    public ArrayList<Product> getProductList(){return productList;}
    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
        if(method==1){
            addProduct(product);
            income-=product.getPrice();
        }
    }
}
