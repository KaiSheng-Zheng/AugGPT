import java.util.ArrayList;

public class Store {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name){
        cnt++;
        id=cnt;
        this.name=name;
        this.income=0;
        this.productList=new ArrayList<>();
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.income=income;
        this.name=name;
        this.productList=productList;
    }
    public boolean hasProduct(Product product){
        boolean a=productList.contains(product);
        return a;
    }
    public boolean addProduct(Product product){
        boolean a=true;
        if(hasProduct(product)){
            a=false;
        }else {
            productList.add(product);
        }
        return a;
    }
    public boolean removeProduct(Product product){
        boolean a=true;
        if(hasProduct(product)){
            productList.remove(product);
        }else {
            a=false;
        }
        return a;
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            if(hasProduct(product)){
                removeProduct(product);
                income+=product.getPrice();
            }else{
                return;
            }
        }if(method==1){
            addProduct(product);
            income-=product.getPrice();
        }
    }
}
