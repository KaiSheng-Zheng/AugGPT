import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private ArrayList<Product> productListCopy = new ArrayList<Product>();

    private float income;


    public Store(String name){
        this.name = name;this.income=0;
        this.productList=getProductList();
        cnt++;this.id=cnt;
        this.productListCopy = null;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;this.id=cnt;
        this.name = name;this.income=income;
        this.productList.addAll(productList);
        this.productListCopy.addAll(productList);
    }

    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income = income + product.getPrice();
        }else if (method == 1){
            productList.add(product);
            income = income-product.getPrice();
        }
    }
}
