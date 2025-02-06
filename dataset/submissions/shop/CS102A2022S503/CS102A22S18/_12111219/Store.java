import java.util.ArrayList;

public class Store {
    //Attributes
    private static int cnt=0;
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    //Constructors
    public Store(String name){
        this.name=name;
        this.income=0;
//        this.productList=null;
        cnt++;
        this.id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        this.name=name;
        this.income=income;
        this.productList=productList;
        cnt++;
        this.id=cnt;
    }

    //Methods
    public boolean hasProduct(Product product){
    if(productList.contains(product)){
        return true;
    }
    return false;
    }
    public boolean addProduct(Product product){
        if(productList.contains(product)){
            return false;
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product){
        if(productList.contains(product)){
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method==0){
            this.removeProduct(product);
            income=income+product.getPrice();
        }
        if (method==1){
        this.addProduct(product);
        income=income-product.getPrice();
        }
    }
}
