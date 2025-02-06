import java.util.ArrayList;
public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

   public Store(String name) {
        this.name = name;
        this.income = 0;
        this.productList = new ArrayList<>();
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product){
        boolean a =  productList.contains(product);
        return a;
    }

    public boolean addProduct(Product product){
        if (hasProduct(product)){
            return false;
        }else {
            productList.add(product);
            return true;
        }

    }

    public boolean removeProduct(Product product){
        if (!hasProduct(product)){
            return false;
        }else {
            productList.remove(product);
            return true;
        }
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public void transact(Product product, int method){
        if(method == 0){
            removeProduct(product);
            this.income = this.income + product.getPrice();
        }
        if (method == 1){
            addProduct(product);
            this.income = this.income - product.getPrice();
            
        }

    }

}