import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        cnt++;
        this.id = cnt;
        this.income = 0;
        this.productList = new ArrayList<Product>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        cnt++;
        this.id = cnt;
        this.income = income;
        this.productList = productList;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (productList.contains(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
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
            this.removeProduct(product);
            income = income + product.getPrice();
        } else if (method == 1) {
            this.addProduct(product);
            income = income - product.getPrice();
        }
    }
}
