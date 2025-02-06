import java.util.ArrayList;

public class Store {
    private static int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;
    private ArrayList<Product> soldList = new ArrayList<>();

    public Store(String name) {
        Store.cnt++;
        this.id = Store.cnt;
        this.name = name;
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
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product) {
        if (hasProduct(product)) {
            return false;
        }
        this.productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        return this.productList.remove(product);
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            if (removeProduct(product)) {
                this.income += product.getPrice();
                soldList.add(product);
            }
        } else if (method == 1) {
            if (this.soldList.contains(product)) {
                addProduct(product);
                this.income -= product.getPrice();
                this.soldList.remove(product);
            }
        }
    }
}