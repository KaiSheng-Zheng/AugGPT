import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    private Integer a;

    public Store(String name) {
        productList = new ArrayList<>();
        this.name = name;
        id = ++cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        if (productList == null)
            this.productList = new ArrayList<>();
        else
            this.productList = productList;
        this.name = name;
        this.income = income;
        id = ++cnt;
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
            if (removeProduct(product))
                income += product.getPrice();
        } else {
            if (addProduct(product))
                income -= product.getPrice();
        }
    }
}
