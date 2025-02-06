import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.income = 0;
        this.productList = new ArrayList<Product>();
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.income = income;//given income
        this.productList = productList;
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).zainamai = id;
            productList.get(i).shangdian = this;
        }
        this.name = name;
    }

    public boolean hasProduct(Product product) {
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (product.zainamai > 0) return false;//the product is in the store
        product.zainamai = this.id;
        product.shangdian = this;
        this.productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        if (product.zainamai == id) {
            this.productList.remove(product);
            product.zainamai = 0;
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            removeProduct(product);
            this.income += product.getPrice();
        }
        if (method == 1) {
            this.addProduct(product);
            this.income -= product.getPrice();
        }
    }
    public int getId() {
        return this.id;
    }
}
