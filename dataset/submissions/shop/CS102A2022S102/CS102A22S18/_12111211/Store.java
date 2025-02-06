import java.util.ArrayList;
public class Store {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income=0;

    public Store(String name){
        cnt++;
        income=0;
        id=1;
        this.name=name;
    }

    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.id=cnt;
        this.income=income;
        this.productList=productList;
        this.name=name;
    }

    public boolean hasProduct(Product product){
        if(this.productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }

    public boolean addProduct(Product product){
        if(this.productList.contains(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product){
        if(this.productList.contains(product)){
            productList.remove(product);
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);
            income+=product.getPrice();
        }
        if(method==1){
            productList.add(product);
            income-=product.getPrice();
        }
    }



}
