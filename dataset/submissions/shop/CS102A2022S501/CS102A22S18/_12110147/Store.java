import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        Store.cnt++;
        this.id = Store.cnt;
        this.name = name;
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        Store.cnt++;
        this.id = Store.cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        if (this.productList.contains(product)) {
            return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (!this.productList.contains(product)) {
            this.productList.add(product);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        if (this.productList.contains(product)) {
            this.productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            if (removeProduct(product)) {
                this.income = this.income + product.getPrice();
            }
        }
        if (method == 1) {
            if (addProduct(product)) {
                this.income = this.income - product.getPrice();
            }

        }

    }
}