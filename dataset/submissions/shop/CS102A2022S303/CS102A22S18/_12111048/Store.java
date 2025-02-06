import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();;
    private float income;

    public Store(String name) {
        this.name = name;
        cnt += 1;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt += 1;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        if (getProductList().size() > 0) {
            for (Product product1 : getProductList()) {
                if (product1.getId() == product.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (getProductList().size() == 0 || !this.hasProduct(product)) {
            getProductList().add(product);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeProduct(Product product) {
        if (this.hasProduct(product)) {
            getProductList().remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        switch (method) {
            case 0:
                getProductList().remove(product);
                this.income = this.income + product.getPrice();
                break;
            case 1:
                getProductList().add(product);
                this.income = this.income - product.getPrice();
                break;
            default:
                System.out.println("method is not defined");
        }
    }
}