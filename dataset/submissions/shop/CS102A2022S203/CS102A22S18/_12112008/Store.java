

import java.util.ArrayList;
import java.util.Objects;

public class Store {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each store and the value is set to cnt.
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.income = 0;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.productList = productList;
        this.income = income;
    }

    public boolean hasProduct(Product product) {
        return this.productList.contains(product);
    }

    public boolean addProduct(Product product) {

        if (this.productList.contains(product)) return false;

        productList.add(product);
        product.setBelongingStore(this);
        return true;


    }

    public boolean removeProduct(Product product) {
        boolean flag = false;
        if (this.productList.contains(product))flag=true;
        if (flag) {
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
            productList.remove(product);
            income += product.getPrice();
        }
        if (method == 1) {
            productList.add(product);
            income -= product.getPrice();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id && Float.compare(store.income, income) == 0 && name.equals(store.name) && productList.equals(store.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productList, income);
    }
}
