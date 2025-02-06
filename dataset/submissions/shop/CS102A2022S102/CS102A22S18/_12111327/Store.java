import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        this.productList = new ArrayList<>();
        id = ++cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this(name);
        productList.forEach(product -> product.setStore(this));
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
    }

    private boolean hasProductById(Product product) {
        return productList.stream().anyMatch(p -> p.getId() == product.getId());
    }

    public boolean addProduct(Product product) {
        if (hasProductById(product)) {
            return false;
        }
        product.setStore(this);
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            income += product.getPrice();
        } else if (method == 1) {
            productList.add(product);
            income -= product.getPrice();
        }
    }
}
