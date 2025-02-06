import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        this.name=name;
        id=++cnt;
        income=0;
        productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        id=++cnt;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            this.productList.add(product);
            return true;
        }
        else return false;
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)) {
            this.productList.remove(product);
            return true;
        }
        else return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            this.productList.remove(product);
            income+=product.getPrice();
        }else if(method==1){
            this.productList.add(product);
            income-=product.getPrice();
        }
    }
}
