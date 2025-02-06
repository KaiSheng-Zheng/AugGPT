import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name) {
        Store.cnt++;
        this.id = Store.cnt;
        this.name = name;
        this.income = 0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        Store.cnt++;
        this.id = Store.cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        if(this.productList.contains(product)){
            return true;
        }else{
            return false;
        }
    }
    public boolean addProduct(Product product){
        if(!hasProduct(product)){
            return this.productList.add(product);
        }else{
            return false;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            return this.productList.remove(product);
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList() {
        return this.productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(hasProduct(product)) {
                removeProduct(product);
                this.income += product.getPrice();
            }
        }
        if(method==1){
            if(!hasProduct(product)) {
                addProduct(product);
                this.income -= product.getPrice();
            }
        }
    }
    }

