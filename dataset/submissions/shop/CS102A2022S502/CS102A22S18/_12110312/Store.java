import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        Store.cnt++;
        this.id = Store.cnt;
        this.name = name;
        this.productList = new ArrayList<Product>();
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
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product))
            return false;
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        if (!hasProduct(product))
            return false;
        productList.remove(product);
        return true;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            this.income += product.getPrice();
        }
        else if (method == 1) {
            productList.add(product);
            this.income -= product.getPrice();
        }
    }
}
