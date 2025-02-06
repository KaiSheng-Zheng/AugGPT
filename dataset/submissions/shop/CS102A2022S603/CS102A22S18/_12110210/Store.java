import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        this.name=name;
        this.income=0;
        this.productList=new ArrayList<>();
        ++cnt;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.income=income;
        this.productList=productList;
        ++cnt;
        this.id=cnt;
    }
    public boolean hasProduct(Product product){
        if(this.productList.contains(product)){
            return true;
        }else{
            return false;
        }
    }
    public boolean addProduct(Product product){
        if(this.productList.contains(product)){
            return false;
        }else{
            this.productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(this.productList.contains(product)){
            this.productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        float pri = product.getPrice();
        if(method==0){
            this.productList.remove(product);
            this.income=income+pri;
        }else if(method==1){
            this.productList.add(product);
            this.income=income-pri;
        }
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
