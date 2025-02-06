
import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        this.id=cnt;
        this.name=name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
    }
    public boolean hasProduct(Product product){
        for (Product value : productList) {
            if (product.getId() == value.getId()) {
                return true;
            }
        }
        return false;
        }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else if (product.getStoreid()>0){
            return false;
        }else {
            productList.add(product);
            product.setStoreid(this.id);

            return true;}
        }
    public boolean removeProduct(Product product){
        boolean a=true;
        for (int i=0;i<this.productList.size();i++){
            if (product.getId()==this.productList.get(i).getId()){
                a= true;
                this.productList.remove(i);
                break;
            }else {
                a= false;
            }
    }return a;}
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income=income+product.getPrice();
        }else if (method==1){
            productList.add(product);
            income=income-product.getPrice();
        }
    }
}
