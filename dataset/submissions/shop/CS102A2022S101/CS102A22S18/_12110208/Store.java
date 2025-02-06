
import java.util.ArrayList;
public class Store {
    private static int cnt ; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(){}
    public Store(String name) {
        this.name = name;
        cnt ++;
        this.id = cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        for (Product product : productList) {
            this.productList.add(product);
        }
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(productList.contains(product)){
            return false;
        }else{
            this.productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
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
        if(method == 0){
            this.productList.remove(product);
            this.income += product.getPrice();
        }else if(method == 1){
            addProduct(product);
            this.income -= product.getPrice();
        }
    }
}
