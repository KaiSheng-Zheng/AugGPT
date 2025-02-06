import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
    }
    public boolean hasProduct(Product product){
        return true;
    }
    public boolean addProduct(Product product){
        return true;
    }
    public boolean removeProduct(Product product){
        return true;
    }
    public ArrayList<Product> getProductList(){

        return null;
    }
    public void transact(Product product, int method){

    }
}