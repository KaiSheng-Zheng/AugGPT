import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    //Product product;
    //private HashMap<Product,Store> map =new HashMap<>();
    public Store (String name){
         cnt ++;
         this.id =cnt;
         income = 0;
         this.name = name;
         productList = new ArrayList<Product>();
    }
    public Store (String name,ArrayList<Product>productList,float income){
                 cnt++;
                 this.id = cnt;
                 this.name =name;
                 this.income = income;
                 this.productList=productList;
    }
    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }else {
            return false;
        }
    }
    public boolean addProduct(Product product) {
        if (productList.contains(product)) {
            return false;
        } else {
               productList.add(product);
               //map.put(product,store);
               return true;
        }
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)){
            productList.remove(product);
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product,int method){
       if (method == 0){
           productList.remove(product);
           income = income + product.getPrice();
       }
       if (method == 1){
           productList.add(product);
           income = income -product.getPrice();
       }
    }
}
