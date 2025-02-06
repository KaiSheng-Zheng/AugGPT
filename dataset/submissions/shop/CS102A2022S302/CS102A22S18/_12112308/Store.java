import java.util.ArrayList;
import java.util.Objects;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    public static ArrayList<Product> productList1 = new ArrayList<>();

    public Store(String name) {
        this.name = name;
        cnt++;
        this.id = cnt;

    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList.addAll(productList);
        this.productList1.addAll(productList);
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        for (Product value : productList) {
            if (Objects.equals(product.toString(), value.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        for (Product value : productList) {
            if (product.toString().equals(value.toString())) {
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (product.toString().equals(productList.get(i).toString())) {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;

    }

    public ArrayList<Product> getProductList1() {
        return productList1;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            this.income += product.getPrice();
        } else if (method == 1) {
            productList.add(product);
            this.income -= product.getPrice();
        }
    }
}
