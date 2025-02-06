import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.id = 1;
        this.name = name;
        this.productList = productList;
        cnt = cnt + 1;
        this.income = income;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.id = 1;
        this.name = name;
        this.productList = productList;
        cnt = cnt + 1;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        if (hasProduct(product)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return true;
        } else {
            addProduct(product);
            return true;
        }
    }

    public boolean removeProduct (Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
         }else{
            return false;
         }
    }
    public ArrayList<Product> getProductList(){
        return  productList;
    }
    public void transact(Product product, int method){
        if (method ==0){
            removeProduct(product);
            income = income+product.getPrice();
        }
    }
}