import java.util.ArrayList;
public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;
    public Store(String name) {
        ArrayList<Product> a = new ArrayList<>();
        this.name = name;
        this.productList = a;
        this.income = 0.00F;
        id = 1+cnt;
        cnt++;
    }
    public int getId(){
        return id;
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        id = 1+cnt;
        cnt++;
    }
    public boolean hasProduct(Product product) {
        if (productList.contains(product)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean addProduct(Product product) {
        if (productList.contains(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }
    public boolean removeProduct(Product product){
        if (productList.contains(product)) {
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    public void transact(Product product, int method) {
        if (method == 0) {
            if (hasProduct(product)) {
                income = income + product.getPrice();
                productList.remove(product);
            }
        } else if (method == 1) {
            if (hasProduct(product)) {
            } else {
                income = income - product.getPrice();
                productList.add(product);
            }
        }
    }
    public void setIn(float money) {
        income = income - money;
    }
    public float getIncome() {
        return income;
    }
}
