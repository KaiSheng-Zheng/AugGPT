import java.util.ArrayList;

public class Store {
    private static int cnt=0;
    private  int id;
    private final String name;
    private ArrayList<Product> productList=new ArrayList<>();
    private float income;

    public int getId() {
        return id;
    }

    public Store(String name){
        this(name,new ArrayList<Product>(),0);
    }
   public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id=cnt;
        this.name=name;
        this.productList=productList;
        this.income=income;
   }
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
//        product.setId(id);
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
            removeProduct(product);
            income=income+product.getPrice();
        }
        if (method==1){
            addProduct(product);
            income=income-product.getPrice();
        }
    }


}
