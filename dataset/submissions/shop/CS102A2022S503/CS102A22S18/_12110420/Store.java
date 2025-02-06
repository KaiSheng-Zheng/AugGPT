import java.util.ArrayList;
import java.util.Comparator;

public class Store {
    private static int cnt = 0;
    private int id = 1;
    private String name = "";
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income = 0;

    public Store(String name) {
        this.name = name;
        this.id = ++cnt;
        this.income = 0;
        this.productList = new ArrayList<Product>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.id = ++cnt;
        this.income = income;
        this.productList = productList;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (!productList.contains(product)) {
            productList.add(product);
            return true;
        } else {
            return false;
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
            income += product.getPrice();
        } else if (method == 1) {
            this.addProduct(product);
            income -= product.getPrice();
        }
    }
}
