import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name){
        cnt++;
        id = cnt;
        this.name = name;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
          
        int judge = 0;
          for (Product value : productList) {
            if (product == value) {
                judge = 1;
                break;
            }
        }
        return judge == 1;
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (hasProduct(product)){
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void transact(Product product, int method){
         if (method == 0){
             if (removeProduct(product)) {
                 income = income + product.getPrice();
             }
         } else if (method == 1){
             productList.add(product);
             income = income - product.getPrice();
         }
    }
}
