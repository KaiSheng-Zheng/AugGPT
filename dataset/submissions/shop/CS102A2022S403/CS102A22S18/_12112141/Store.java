

import java.util.ArrayList;
import java.util.Iterator;

public class Store {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList;
    private float income;

    public Store(String name) {
        this.name = name;
        productList = new ArrayList<Product>();
        cnt = cnt + 1;
        this.id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        this.productList = productList;
        this.income = income;
        cnt = cnt + 1;
        this.id = cnt;
    }

    public boolean hasProduct(Product product) {
        for (Product product1 : this.productList) {
            if (product.getName().equals(product1.getName()))
                return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        for (Product product1 : this.productList) {
            if (product.getName().equals(product1.getName()))
                return false;
        }
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product next = iterator.next();
            if (product.getName().equals(next.getName())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void transact(Product product, int method) {
        if (method == 0) {
            productList.remove(product);
            income = income + product.getPrice();
        } else if (method == 1) {
            productList.add(product);
            income = income - product.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                ", income=" + income +
                '}';
    }
}

