import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.id=this.cnt;
        this.name=name;
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=this.cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }

    public boolean hasProduct(Product product){
        if (this.productList.contains(product)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addProduct(Product product){
        if (this.hasProduct(product)){
            return false;
        }
        else {
            this.productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (this.hasProduct(product)){
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
        if (method==0){
            this.removeProduct(product);
            this.income+=product.getPrice();
        }
        if (method==1){
            if (this.addProduct(product)){
                this.income-=product.getPrice();
            }
        }
    }

    public static int getCnt() {
        return cnt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getIncome() {
        return income;
    }
}
