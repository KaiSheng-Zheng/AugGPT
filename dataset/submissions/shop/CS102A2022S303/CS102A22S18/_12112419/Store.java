import java.util.ArrayList;
import java.util.Iterator;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
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

    public boolean hasProduct(Product product) {
        while (productList.size() != 0) {
            for (int i = 0; i < productList.size(); i++) {
                while (productList.get(i) == product) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
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
            productList.remove(product);
            income += product.getPrice();
        }
        if (method == 1) {
            productList.add(product);
            income -= product.getPrice();
        }
    }
}