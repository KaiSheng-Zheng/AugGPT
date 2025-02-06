import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Store(String name) {
        this.name = name;
        cnt = cnt + 1;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt = cnt + 1;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (Product value : productList) {
            if (value == product) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else return productList.add(product);
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        } else return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            income = income + product.getPrice();
        }
        if (method == 1) {
            addProduct(product);
            income = income - product.getPrice();
        }
    }
}
