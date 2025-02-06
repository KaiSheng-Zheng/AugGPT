import java.util.ArrayList;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        id = ++cnt;
        income = 0;
        this.name = name;
        productList = new ArrayList<>(0);
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        id = ++cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getIncome() {
        return income;
    }

    public boolean hasProduct(Product product) {
        for (Product product1 : productList) {
            if (product1.getID() == product.getID())
                return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {//ac one case
        if (hasProduct(product)) return false;
        else {
            productList.add(product);
            return true;
        }
    }

    public boolean removeProduct(Product product) {//wa
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        } else return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) { //has bought
            if (removeProduct(product)) {
                income = income + product.getPrice();
            }
        }
        if (method == 1) { //want refund
            if (addProduct(product)){
                income=income- product.getPrice();
            }
        }
    }
}