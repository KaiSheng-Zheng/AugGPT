import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = new ArrayList<Product>();
        this.income = income;

    }

    public boolean hasProduct(Product product) {
        if (productList.contains(product)) {
            return true;
        } else return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            this.productList.add(product);
            return true;
        } else return false;
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            this.productList.remove(product);
            return true;
        } else return false;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            this.productList.remove(product);
            this.income += income;
        }
    }
}