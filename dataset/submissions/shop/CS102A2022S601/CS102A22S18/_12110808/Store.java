import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private  String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        cnt++;
        this.id=cnt;
        this.income=0;
        this.productList=new ArrayList<>();
        this.name=name;
    }
    public Store(String name,ArrayList<Product> productList,float income){
        cnt++;
        this.id=cnt;
        this.income=income;
        this.productList=productList;
        this.name=name;
    }
    public boolean hasProduct(Product product){
        boolean q=false;
        if (this.productList==null){
            return false;
        }else {
            int n=this.productList.size();
            for (int i=0;i<n;i++){
                if (productList.get(i)==product){
                    q=true;
                    break;
                }
            }
        }
        return q;
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
        if (!hasProduct(product)){
            return false;
        }else {
            productList.remove(product);
            return true;
        }
    }
    public ArrayList<Product>  getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income+=product.getPrice();
        } else if (method==1) {
            productList.add(product);
            income-=product.getPrice();
        }
    }
    public void addIncome(float a){
        this.income+=a;
    }
}
