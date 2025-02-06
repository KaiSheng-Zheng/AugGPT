import java.util.ArrayList;
import java.util.HashMap;

    public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    private HashMap<Integer, Customer> order = new HashMap<>();

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public Store(String name) {
        this.id = ++cnt;
        this.name = name;
        productList = new ArrayList<>();
        this.income = 0;

    }

    public int getId() {
        return id;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.id = ++cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                return true;
            }
        }
        return false;
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
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            this.removeProduct(product);
            income += product.getPrice();
        }
        if (method == 1) {
            this.addProduct(product);
            income -= product.getPrice();
        }
    }

}
