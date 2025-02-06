import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        this.name=name;
        income=0;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name=name;
        this.income=income;
        id=cnt;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        int m=0;
        for (Product value : productList) {
            if (product.equal(value)) {
                m = 1;
                break;
            }
        }
        if(m==1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean addProduct(Product product){
        int m=0;
        for (Product value : productList) {
            if (product.equal(value)) {
                m = 1;
                break;
            }
        }
        if(m==1){
            return false;
        }
        else{
            productList.add(product);
            product.setFromStore(this);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        int m=0;
        for (Product value : productList) {
            if (product.equal(value)) {
                m = 1;
                break;
            }
        }
        if(m==1){
            productList.remove(product);
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            removeProduct(product);
            income+=product.getPrice();
            product.setFromStore(this);
        }
        else if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }

}