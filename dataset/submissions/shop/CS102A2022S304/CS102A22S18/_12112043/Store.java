import java.util.ArrayList;
import java.util.Collections;

public class Store {
    private static int cnt = 0;
    private int id = 1;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name = name;
        this.income=0;
        cnt++;
        this.id = cnt;
        this.productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }
    public boolean hasProduct(Product product){
        if (this.productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        int count = Collections.frequency(this.productList,product);
        if (count==0) {
            this.productList.add(product);
            return true;
        }else{
            return false;
        }
    }
    public boolean removeProduct(Product product){
        int count = Collections.frequency(productList,product);
        if (count!=0) {
                this.productList.remove(product);
                return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            this.productList.remove(product);
            this.income+=product.getPrice();
        } else if (method==1) {
            this.productList.add(product);
            this.income-=product.getPrice();
        }
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
