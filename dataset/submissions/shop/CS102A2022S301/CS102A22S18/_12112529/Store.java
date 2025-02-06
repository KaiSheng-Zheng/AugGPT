import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
//
    public Store(String name){
        this.name = name;
        this.income=0;
        cnt++;
        id = cnt;
    }
    public Store(String name,ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

//
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public  boolean addproduct(Product product){
        if (hasProduct(product)) {
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            return false;
        }
        else {
            productList.remove(product);
            return true;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            income = income + product.getPrice();
            removeProduct(product);
        }
        else {
            income = income- product.getPrice();
            productList.add(product);
        }
    }
 }