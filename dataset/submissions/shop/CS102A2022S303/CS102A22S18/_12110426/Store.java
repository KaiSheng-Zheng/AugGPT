import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;cnt++;this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;this.productList=productList;this.income=income;cnt++;this.id=cnt;
    }
    public boolean hasProduct(Product product){
        if (this.productList.contains(product)){
            return true;
        }else
            return false;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else
            this.productList.add(product);return true;
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            this.productList.remove(product);return true;
        }else
            return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            this.productList.remove(product);this.income=this.income+product.getPrice();
        }else if (method==1){
            this.productList.add(product);this.income=this.income-product.getPrice();
        }
    }

    public void setIncome(float income) {
        this.income = income;
    }
}