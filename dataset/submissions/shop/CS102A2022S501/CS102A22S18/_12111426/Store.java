import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt=cnt+1;
        id=cnt;
        this.name=name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt=cnt+1;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }
        return false;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            this.income=income+ product.getPrice();
        }
        if (method==1){
            productList.add(product);
            this.income=income-product.getPrice();
        }
    }
}
