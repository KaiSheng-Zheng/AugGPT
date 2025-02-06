import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        this.name=name;
        this.id=++cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.income=income;
        this.name=name;
        this.productList=productList;
        this.id=++cnt;
    }
    public boolean hasProduct(Product product){
        if(this.productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        if(this.productList.contains(product)){
            return false;
        }else {
            this.productList.add(product);
            product.setStore(this);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(this.productList.contains(product)){
            this.productList.remove(product);
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            this.income=this.income+product.getPrice();
        }
        if(method==1){
            addProduct(product);
            this.income=this.income-product.getPrice();
        }
    }
}
