import java.util.ArrayList;
public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        Store.cnt++;
        this.id=Store.cnt;
        this.name=name;
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        Store.cnt++;
        this.id=Store.cnt;
        this.name=name;
        this.income=income;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
            if (this.productList.contains(product))
                return true;
        return false;
    }
    public boolean addProduct(Product product){
            if (hasProduct(product))
                return false;
        else this.productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for (Product a:this.productList){
            if (product==a){
                this.productList.remove(a);
                return true;}}
       return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void transact(Product product, int method){
            if (method==0){ if (removeProduct(product)) {
                this.income+=product.getPrice();
            }}
            if (method==1){
                this.income-=product.getPrice();
                addProduct(product);
            }

    }
}
