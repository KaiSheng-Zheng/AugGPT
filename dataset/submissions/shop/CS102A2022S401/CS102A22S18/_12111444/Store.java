
import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income = 0;
    ArrayList<Product> java = new ArrayList<>();

    public Store(String name){
        this.name = name;
        cnt += 1;
        id = cnt;
        income = 0;
        productList = new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.productList = productList;
        java.addAll(productList);
        this.income = income;
        cnt += 1;
        id = cnt;
    }
    public boolean hasProduct(Product product){
        if(this.productList.contains(product)){
            return true;
        }else{
            return false;
        }
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)){
            return false;
        }else{
            productList.add(product);
            java.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){ //not sure
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method ==0){
            if(hasProduct(product)){
                removeProduct(product);
                this.income += product.getPrice();
            }
        }else{
            addProduct(product);
            this.income -= product.getPrice();
        }
    }
}