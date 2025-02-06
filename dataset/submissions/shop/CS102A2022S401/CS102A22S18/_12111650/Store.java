import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float income;

    public Store(String name) {
        this.name = name;
        this.income = 0;
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product) {
        boolean b = false;
        for (int i = 0; i < productList.size(); i++) {
            if (product.equals(productList.get(i))) {
                b = true;
                break;
            }
        }
        return b;
    }

    public boolean addProduct(Product product) {
        if (!hasProduct(product)) {
            productList.add(product);
            return true;
        } else return false;
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
            productList.remove(product);
            this.income += Float.parseFloat(product.getPrice());
        }
        if (method == 1) {
            productList.add(product);
            this.income -= Float.parseFloat(product.getPrice());
        }
    }
}
