import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;
    private ArrayList<Product> rootProductList;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = 0f;
        this.productList = new ArrayList<>();
        this.rootProductList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = new ArrayList<>(productList);
        this.rootProductList = new ArrayList<>(productList);
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        for (Product i : this.productList) {
            if (i.getId() == product.getId()) return true;
        }
        return false;
    }

    public boolean rootHas(Product product) {
        for (Product i : this.rootProductList) {
            if (i.getId() == product.getId()) return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (!this.hasProduct(product)) {
            productList.add(product);
            if (!this.rootHas(product)) rootProductList.add(product);
            return true;
        } else return false;
    }

    public boolean removeProduct(Product product) {
        if (this.hasProduct(product)) {
            productList.remove(product);
            return true;
        } else return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        switch (method) {
            case 0:
                if (removeProduct(product)) {
                    this.income += product.getPrice();
                }
                break;
            case 1:
                for (Product i : rootProductList) {
                    if (product.getId() == i.getId() && addProduct(product)) {
                        this.income -= product.getPrice();
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }
}
