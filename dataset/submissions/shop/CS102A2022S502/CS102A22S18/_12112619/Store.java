import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).setBelongTo(this);
        }
    }

    public boolean hasProduct(Product product) {
        if (this.productList.contains(product)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addProduct(Product product) {
        if (this.hasProduct(product)) {
            return false;
        } else {
            this.productList.add(product);
            product.setBelongTo(this);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (this.productList.contains(product)) {
            this.productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            this.income += product.getPrice();
            productList.remove(product);
        }
        if (method == 1) {
            this.income -= product.getPrice();
            this.productList.add(product);
        }
    }
}
