import java.util.ArrayList;

public class Store {
    private static int cnt =0;
    private int id;
    private String name;
    private ArrayList<Product> productList =new ArrayList<>();
    private float income;

    public Store(String name){
        cnt++;
        this.name=name;
        this.id=cnt;
        this.income=0;
    }
    public Store(String name, ArrayList<Product> productList, float income){
        cnt++;
        this.name = name;
        this.id = cnt;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product){
        if (hasProduct(product)) {
            return false;
        } else {
            return this.productList.add(product);
        }
    }
    public boolean removeProduct(Product product){
        return this.productList.remove(product);
    }
    public ArrayList<Product> getProductList(){
        return this.productList;
    }

    public void transact(Product product, int method){
        if (method==0){
            removeProduct(product);
            this.income += product.getPrice();
        }
    }
}