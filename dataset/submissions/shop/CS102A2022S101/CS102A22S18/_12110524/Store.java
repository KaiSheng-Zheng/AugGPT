import java.util.ArrayList;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        this.id = ++cnt;
        this.income = 0;
        this.productList = new ArrayList<Product>();
    }
    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.id = ++cnt;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        return this.productList.contains(product);
    }
    public boolean addProduct(Product product) {
        if (!this.productList.contains(product)) {
            this.productList.add(product);
            return true;
        }
        else return false;
    }
    public boolean removeProduct(Product product) {
        if (!this.productList.contains(product)) return false;
        else {
            this.productList.remove(product);
            return true;
        }
    }
    public ArrayList<Product> getProductList() {
        return this.productList;
    }
    public void transact(Product product, int method) {
        switch (method) {
            case 0:
                this.productList.remove(product);
                this.income += product.getPrice();
                break;
            case 1:
                this.productList.add(product);
                this.income -= product.getPrice();
                break;
        }
    }
}