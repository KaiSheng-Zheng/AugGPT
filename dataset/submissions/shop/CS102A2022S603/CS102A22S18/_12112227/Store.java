import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        cnt += 1;
        id = cnt;
        this.productList = new ArrayList<>();
        this.name = name;
        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt += 1;
        id = cnt;
        this.productList = productList;
        this.name = name;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        if (productList.contains(product)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addProduct(Product product) {
        if (productList.contains(product)) {
            return false;
        } else {
            productList.add(product);

            return true;
        }
    }

    public boolean removeProduct(Product product) {
        if (productList.contains(product)) {
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
        switch (method) {
            case (0): {
                productList.remove(product);
                income += product.getPrice();
            }
            case (1): {
                productList.add(product);
                income -= product.getPrice();
            }
        }

    }

    protected int getID() {
        return id;
    }

    protected float getIncome() {
        return income;
    }
}
