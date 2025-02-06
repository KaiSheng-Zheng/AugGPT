import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public Store(String name) {
        this.name = name;
        cnt++;
        this.id = cnt;
        this.income = 0;
        this.productList = new ArrayList<>(0);
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        for (Product p : productList) {
            p.getProductHashMap().replace(p, this);
        }
        this.income = income;
        cnt++;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        } else {
            this.productList.add(product);
            product.getProductHashMap().replace(product, this);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            this.productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            if (removeProduct(product)) this.income += product.getPrice();
        } else {
            if (addProduct(product)) this.income -= product.getPrice();
        }
    }
}
