import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        income = 0;
        productList = new ArrayList<>();
        cnt++;
        id = cnt;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public int getId() {
        return id;
    }

    public boolean hasProduct(Product product) {
        boolean test = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                test = true;
                break;
            }
        }
        if (test) {
            return true;
        } else {
            return false;
        }
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
            removeProduct(product);
            income = income + product.getPrice();
        } else if (method == 1) {
            addProduct(product);
            income = income - product.getPrice();
        }
    }
}
