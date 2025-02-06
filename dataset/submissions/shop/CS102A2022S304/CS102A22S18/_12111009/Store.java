import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        this.name=name;
        income=0;
        cnt+=1;
        id+=1;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt+=1;
        this.id=cnt;
        this.income=income;
        this.name=name;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else {
            this.productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        }else return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            income+=product.getPrice();
        }if (method==1){
            income-=product.getPrice();
            if (!hasProduct(product)){
                addProduct(product);
            }
        }
    }
}