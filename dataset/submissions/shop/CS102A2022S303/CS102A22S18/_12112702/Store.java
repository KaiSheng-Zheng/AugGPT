import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        this.income = 0;
        cnt++;
        id = cnt;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product) {
        for (Product value : productList) {
            if (value.equals(product)) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        if (this.hasProduct(product)) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (this.hasProduct(product)) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == product.getId()) {
                    this.productList.remove(i);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
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

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return income;
    }
}