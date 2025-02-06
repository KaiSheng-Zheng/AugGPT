import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;


    public Store(String name){
        cnt++;
        id = cnt;
        income = 0;
        productList = new ArrayList<>();
        this.name = name;
    }


    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        cnt++;
        id = cnt;
        this.productList = productList;
        this.income = income;
    }


    public boolean hasProduct(Product product){
        if (productList.contains(product)) {
            return true;
        }
        else {
            return false;
        }
    }


    public boolean addProduct(Product product){
        if (productList.contains(product)) {
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }


    public boolean removeProduct(Product product){
        if (productList.contains(product)) {
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
    public float getIncome() {return income;}


    public void transact(Product product, int method){
        if (method == 0) {
            productList.remove(product);
            income = income + product.getprice();
        }
        else if (method == 1) {
            productList.add(product);
            income = income - product.getprice();
        }
    }
}