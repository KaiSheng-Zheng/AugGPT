import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product>productList;
    private float income;
    public Store (String name){
        productList=new ArrayList<>();
        cnt++;
        id=cnt;
        this.name=name;
    }
    public Store(String name,ArrayList<Product>productList,float income){
        this.income=income;
        this.productList=productList;
        this.name=name;
        cnt++;
        id=cnt;
    }
    public boolean hasProduct(Product product){
        return productList.contains(product);
    }
    public boolean addProduct(Product product){
        if(productList.contains(product)){
            return false;
        }
        else{
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        }
        else {
            return false;
        }
        }
    public ArrayList<Product> getProductList(){
        return  productList;
    }
    public void transact(Product product, int method){
        if(method==0){
            productList.remove(product);
            income += product.getPrice();
        }
        if(method==1){
            addProduct(product);
            income-=product.getPrice();
        }
    }
    }