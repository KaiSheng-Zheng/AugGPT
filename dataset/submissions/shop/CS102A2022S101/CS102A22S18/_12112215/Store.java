import java.util.*;
public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        this.name=name;
        this.income=0;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name=name;
        this.productList=productList;
        this.income=income;
        this.id=cnt;
        for (int i = 0; i <productList.size() ; i++) {
            productList.get(i).productsource.add(this);
        }
    }
    public Store(int id){
        this.id=id;
    }
    public boolean hasProduct(Product product){
        if(this.productList.contains(product)){
            return true;
        }else{
            return false;
        }
    }
    public boolean addProduct(Product product){
        if(this.productList.contains(product)){
            return false;
        }else{
            this.productList.add(product);
            product.productsource.add(this);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(this.productList.contains(product)){
            this.productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method) {
        if (method == 0) {
            this.productList.remove(product);
            this.income += product.getPrice();
        }
        if (method == 1) {
                this.productList.add(product);
                this.income -= product.getPrice();
            }
        }
    }


