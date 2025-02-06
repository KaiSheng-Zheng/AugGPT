import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;
    public Store(String name){
        this.name=name;
        this.income=0;
        cnt++;
        this.id=cnt;
    }
    public Store(String name,ArrayList<Product> productlist,float income){
        this.name=name;
        this.income=income;
        this.productList=productlist;
        cnt++;
        this.id=cnt;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(hasProduct(product)==true)
            return false;
        else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if(hasProduct(product)){
            productList.remove(product);
            return true;
        }
        else
            return false;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public  void transact(Product product,int method){
        if (method==0){
            removeProduct(product);
            income+=product.getPrice();
        }
        else if(method==1){
            addProduct(product);
            income-=product.getPrice();
        }
    }
}