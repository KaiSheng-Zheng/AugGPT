

import java.util.ArrayList;

public class Store {
    private static int cnt = 1;
    private final int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
  
    private float income;


    public Store(String name) {
        this.name = name;
        this.id = cnt++;
        this.productList = new ArrayList<>(0);

        this.income = 0;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.id = cnt++;
        this.income = income;

    }

    public void setIncome(float income) {
        this.income = income+this.income;
    }

    public float getIncome() {
        return income;
    }

    public boolean hasProduct(Product product) {
        return productList.contains(product);
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
        if (method == 0) {
            removeProduct(product);
            income = income + product.getPrice();
        }
        if (method == 1) {
            addProduct(product);
            income = income - product.getPrice();
        }
    }
}
