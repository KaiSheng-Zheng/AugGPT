import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public Store(String name) {
        this.name=name;
        cnt++;
        id=cnt;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name=name;
        this.productList=productList;
        this.income=income;
        cnt++;
        id=cnt;
    }
    public void setIncome(float income) {
        this.income = income;
    }
    public float getIncome() {
        return income;
    }
    public boolean hasProduct(Product product) {
        if (productList.contains(product)) {
            return true;
        }
        return false;
    }
    public boolean addProduct(Product product) {
        if (productList.contains(product)) {
            return false;
        }
        productList.add(product);
        return true;
    }
    public boolean removeProduct(Product product) {
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        }
        return false;
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method) {
        if (method==0) {
            removeProduct(product);
            income+=product.getPrice();
        } else {
            addProduct(product);
            income-= product.getPrice();
        }
    }
}
