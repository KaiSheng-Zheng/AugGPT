import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id=0;  // unique for each store and the value is set to cnt.
    private String name="";
    private ArrayList<Product> productList=new ArrayList<>();
    private float income=0;
    public static void main(String[] args) {}
    public Store(String name) {
        this.name=name;
        this.income=0;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.income=income;
        this.productList=productList;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product) {
        for(int i=0;i<this.productList.size();i++){
            if(this.productList.get(i).getId()==product.getId()){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        for(int i=0;i<this.productList.size();i++){
            if(this.productList.get(i).getId()==product.getId()){
                return false;
            }
        }
        this.productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for(int i=0;i<this.productList.size();i++){
            if(this.productList.get(i).getId()==product.getId()){
                this.productList.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public int getId(){
        return id;
    }
    public void transact(Product product, int method){
        if(method==0&&removeProduct(product)==true){
            income=income+product.getprice();
        }
        if(method==1&&addProduct(product)==true){
            income=income-product.getprice();
        }
    }
}
