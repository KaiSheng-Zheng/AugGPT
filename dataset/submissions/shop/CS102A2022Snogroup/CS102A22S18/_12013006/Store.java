import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income = 0;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        for (Product p : productList) p.store = this;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) return false;
        productList.add(product);
        product.store = this;
        return true;
    }

    public boolean removeProduct(Product product) {
        return productList.remove(product);
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            boolean f = removeProduct(product);
            if (f) this.income += product.getPrice();
        } else {
            boolean f = addProduct(product);
            if (f) this.income -= product.getPrice();
            product.store = this;
        }
    }
}