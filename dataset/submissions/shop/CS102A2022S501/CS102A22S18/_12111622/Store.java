import java.util.*;

public class Store {
    private static int cnt;
    private final int id;
    private final String name;
    private final ArrayList<Product> productList = new ArrayList<>();
    private float income;

    public Store(String name) {
        this.name = name;
        cnt++;
        id = cnt;
    }

    public Store(String name, ArrayList<Product> productList, float income) {
        this.name = name;
        if(productList!=null)
            this.productList.addAll(productList);
        this.income = income;
        cnt++;
        id = cnt;
    }

    public boolean hasProduct(Product product) {
        for (Product p1 : productList) {
            if (p1.getId() == product.getId())
                return true;
        }
        return false;
    }

    public boolean addProduct(Product product) {
        for (Product p1 : productList) {
            if (p1.getId() == product.getId()) return false;
        }
        product.setItsStore(this);
        productList.add(product);
        return true;
    }

    public boolean removeProduct(Product product) {
        for (Product p1 : productList) {
            if (p1.getId() == product.getId()) {
                product.setItsStore(null);
                productList.remove(p1);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getProductList() {
        return new ArrayList<>(productList);
    }

    public void transact(Product product, int method) {
        //purchase:
        if (method == 0) {
            income += product.getPrice();
            productList.remove(product);
        }
        //refund:
        if (method == 1) {
            income -= product.getPrice();
            productList.add(product);
        }
    }
}