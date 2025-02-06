import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name){
        this.name=name;
        this.income=0;
        productList=new ArrayList<>();
        cnt++;
        id=cnt;
    }
    public Store(String name,ArrayList<Product>productsList,float income){
        this.name=name;
        this.income=income;
        this.productList=productsList;
        cnt++;
        id=cnt;
    }

    public boolean hasProduct(Product product){
        return productList.contains(product);
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)) {
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product,int method){
        if (method==0){
            if (removeProduct(product)) {
                this.income = this.income + product.getPrice();
            }
        }
        else {
            if (addProduct(product)) {
                this.income = this.income - product.getPrice();
            }
        }
    }
}
