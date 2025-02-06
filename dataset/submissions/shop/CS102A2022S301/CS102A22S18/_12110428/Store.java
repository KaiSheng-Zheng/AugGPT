import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income;


    public Store(String name){
        this.id = ++cnt;
        this.name = name;
        this.income = 0;
    }
    //1
    public boolean hasProduct(Product product){
        if (productList.contains(product)){
            return true;
        }
        else {
            return false;
        }
    }
    //2
    public boolean addProduct(Product product){
        if (productList.contains(product)){
            return false;
        }
        else {
            productList.add(product);
            return true;
        }
    }
    //3
    public boolean removeProduct(Product product) {
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        }
        else {
            return false;
        }
    }
    //4
    public ArrayList<Product> getProductList(){
        return productList;
    }


    public Store(String name, ArrayList<Product> productList, float income){
        this.id = ++cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
    }

    public void transact(Product product, int method){
        if (method == 0){
            productList.remove(product);
            income = income + product.getPrice();
        }
        else if (method== 1){
            productList.add(product);
            income = income - product.getPrice();
        }
    }
}
