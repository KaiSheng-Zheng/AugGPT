import java.util.ArrayList;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt += 1;
        id = cnt;
        this.name = name;
        income = 0;
        productList = new ArrayList<>();
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.income = income;
        this.productList = productList;
    }

    public boolean hasProduct(Product product) {
        int mark = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                mark = 1;
            }
        }
        if (mark == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addProduct(Product product) {
        if (!hasProduct(product)) {
            productList.add(product);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeProduct(Product product) {
        if (hasProduct(product)) {
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        //product must exist?
        if (method == 0) {
            removeProduct(product);
            income += product.getPrice();
        } else if (method == 1) {
            addProduct(product);
            income -= product.getPrice();
        }
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }
}
