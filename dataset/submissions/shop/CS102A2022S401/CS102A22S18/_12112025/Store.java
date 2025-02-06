
import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        id=cnt;
        this.income=0; this.name=name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;id=cnt;
        this.name=name; this.productList=productList; this.income=income;
    }

    public boolean hasProduct(Product product){
        if(productList.contains(product)){
            boolean hasProduct=true;
            return hasProduct;
        }else {
            boolean hasProduct=false;
            return hasProduct;}
    }
    public boolean addProduct(Product product){
        if(productList.contains(product)){
            boolean addProduct=false;
            return addProduct;
        }else {
            productList.add(product);
            boolean addProduct=true;
            return addProduct;
        }
    }
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(productList.indexOf(product));
            boolean removeProduct=true;
            return removeProduct;
        }else {
            boolean removeProduct=false;
            return removeProduct;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            productList.remove(product);
            this.income=income+product.getPrice();
        }
        if (method==1){
            productList.add(product);
            this.income=income-product.getPrice();
        }

    }
public static ArrayList<Product> setProductList(){
        return setProductList();
}
public static float setIncome(){
        return setIncome();
}

}
