import java.util.ArrayList;
public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList =new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        cnt++;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.income=income;
        cnt++;
        this.id=cnt;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        for (int i=0;i<productList.size();i++){
            if(product.equals(productList.get(i))){
                return true;
            }
        }
        return false;
    }
    public boolean addProduct(Product product){
        for (int i=0;i<productList.size();i++){
            if(product.equals(productList.get(i))){
                return false;
            }
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        for (int i=0;i<productList.size();i++){
            if(product.equals(productList.get(i))){
                productList.remove(product);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    };
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            income=income+product.getPrice();
        }
        if (method==1){
            productList.add(product);
            income=income-product.getPrice();
        }
    }
}
