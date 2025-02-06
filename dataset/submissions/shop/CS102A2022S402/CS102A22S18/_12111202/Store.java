package Lab;
import java.util.ArrayList;

public class Store {
    private static int cnt;
private int id;
private String name;
private ArrayList<Product> productList;
private float income;
public Store(String name){
    this.name=name;
    cnt++;
}
public Store(String name, ArrayList<Product> productList, float income){
    this.name=name;
    this.income=income;
    this.productList=productList;
    cnt++;
}
    public boolean hasProduct(Product product){
    for (int i=0;i<productList.toArray().length;i++){
        if (product==this.productList.get(i)){
            return true;
        }
    }
        return false;
    }
    public boolean addProduct(Product product){
    if (this.hasProduct(product)==true){
        return false;
    }
    else {
    this.productList.add(product);
    return true;}
    }
    public boolean removeProduct(Product product){
        for (int i=0;i<productList.toArray().length;i++){
            if (product==this.productList.get(i)){
                this.productList.remove(i);
            }
            return true;
        }
        return false;
    }
    public ArrayList<Product> getProductList(){
    return productList;
    }
    public void transact(Product product, int method){
    if (method==0){
        removeProduct(product);
        income=income+product.getPrice();
    }
    }
}
