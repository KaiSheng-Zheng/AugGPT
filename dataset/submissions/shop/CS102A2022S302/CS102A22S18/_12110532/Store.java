import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        id = cnt;
        this.income = 0;
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        boolean n;
        if (productList.contains(product)) {
            n = true;
        } else {
            n = false;
        }
        return n;
    }

    public boolean addProduct(Product product) {
        boolean n;
        if (productList.contains(product)) {
            n = false;
        } else {
            productList.add(product);
            n = true;
        }
        return n;
    }

    public boolean removeProduct(Product product) {
        boolean n;
        if (productList.contains(product)) {
            productList.remove(product);
            n = true;
        } else {
            n = false;
        }
        return n;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            income += product.getPrice();
        } else if (method == 1) {
            productList.add(product);
            income -= product.getPrice();
        }
    }
}