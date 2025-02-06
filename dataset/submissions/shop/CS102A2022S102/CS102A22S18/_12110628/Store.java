import java.util.ArrayList;
public class Store {
    private static int cnt = 0;
    private int id = 0;
    private String name = "";
    private ArrayList<Product> productList = new ArrayList<>(0);
    private float income;
    public Store(String name) {
        cnt += 1;
        this.id = cnt;
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>(0);
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt += 1;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        if (this.productList.contains(product)){
            return false;
        }
        this.productList.add(product);
        this.income -= product.getPrice();
        return true;
    }
    public boolean removeProduct(Product product){
        if (!this.productList.contains(product)){
            return false;
        }
        this.productList.remove(product);
        this.income += product.getPrice();
        return true;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
        if (method == 0){
            removeProduct(product);
        }
        else {
            addProduct(product);
        }
    }
}